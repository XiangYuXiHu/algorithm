package com.smile.snowFlake;

/**
 * 分布式主键雪花算法
 * 参考：https://segmentfault.com/a/1190000011282426
 *
 * @Description
 * @ClassName IdWorker
 * @Author smile
 * @date 2022.09.24 23:35
 */
public class IdWorker {

    /**
     * 工作id
     */
    private long workerId;
    /**
     * 数据id
     */
    private long dataCenterId;
    /**
     * 12位序列号
     */
    private long sequence;

    /**
     * 初始时间
     */
    private long twepoch = 1288834974657L;

    /**
     * 长度5位
     */
    private long workerIdBits = 5L;
    private long dataCenterIdBits = 5L;

    /**
     * 最大值
     */
    private long maxWorkerId = -1L ^ (-1L << workerIdBits);
    private long maxDataCenterId = -1L ^ (-1L << dataCenterIdBits);
    /**
     * 序列号id长度
     */
    private long sequenceBits = 12L;
    /**
     * 序列号最大值
     */
    private long sequenceMask = -1L ^ (-1L << sequenceBits);

    /**
     * 工作id需要左移的位数，12位
     */
    private long workerIdShift = sequenceBits;
    /**
     * 数据id需要左移位数 12+5=17位
     */
    private long dataCenterIdShit = sequenceBits + workerIdBits;
    /**
     * 时间戳需要左移位数 12+5+5=22位
     */
    private long timestampLeftShift = sequenceBits + workerIdBits + dataCenterId;
    /**
     * 上次时间戳，初始值为负数
     */
    private long lastTimestamp = -1;

    /**
     * @param workerId
     * @param dataCenterId
     * @param sequence
     */
    public IdWorker(long workerId, long dataCenterId, long sequence) {
        if (workerId > maxWorkerId || workerId < 0) {
            String exceptionInfo = String.format("worker id can't be greater than %d or less then 0", maxDataCenterId);
            throw new IllegalArgumentException(exceptionInfo);
        }
        if (dataCenterId > maxDataCenterId || dataCenterId < 0) {
            String exceptionInfo = String.format("dataCenter Id can't be greater than %d or less than 0", dataCenterId);
        }
        System.out.printf("worker starting. timestamp left shift %d, dataCenter id bits %d, worker id bits %d, sequence bits %d, workerId %d",
                timestampLeftShift, dataCenterIdBits, workerIdBits, sequenceBits, workerId);
        this.workerId = workerId;
        this.dataCenterId = dataCenterId;
        this.sequence = sequence;
    }

    public long getWorkerId() {
        return workerId;
    }

    public long getDataCenterId() {
        return dataCenterId;
    }

    public long getTimestamp() {
        return System.currentTimeMillis();
    }

    /**
     * 获取系统时间
     *
     * @return
     */
    private long timeGen() {
        return System.currentTimeMillis();
    }

    /**
     * 获取时间戳，并与上次时间戳比较
     *
     * @param lastTimestamp
     * @return
     */
    private long timNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * 下一个ID生成算法
     *
     * @return
     */
    public synchronized long nextId() {
        long timestamp = timeGen();

        if (timestamp < lastTimestamp) {
            String exceptionInfo = String.format("clock is moving backwards,Refusing to generate id for %d milliseconds", lastTimestamp - timestamp);
            throw new RuntimeException(exceptionInfo);
        }

        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = timNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }
        lastTimestamp = timestamp;
        /**
         * 返回结果：
         * (timestamp - twepoch) << timestampLeftShift) 表示将时间戳减去初始时间戳，再左移相应位数
         * (dataCenterId << dataCenterIdShift) 表示将数据id左移相应位数
         * (workerId << workerIdShift) 表示将工作id左移相应位数
         * | 是按位或运算符，例如：x | y，只有当x，y都为0的时候结果才为0，其它情况结果都为1。
         * 因为个部分只有相应位上的值有意义，其它位上都是0，所以将各部分的值进行 | 运算就能得到最终拼接好的id
         */
        return ((timestamp - twepoch) << timestampLeftShift) |
                (dataCenterId << dataCenterIdShit) |
                (workerId << workerIdShift) |
                sequence;
    }

    public static void main(String[] args) {
        IdWorker worker = new IdWorker(1, 1, 1);
        for (int i = 0; i < 30; i++) {
            System.out.println(worker.nextId());
        }
    }
}
