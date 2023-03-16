package com.smile.algorithm;

import java.math.BigDecimal;
import java.util.Random;

/**
 * 微信抢红包 二倍均值法
 * 2 * 剩余金额/剩余红包数
 *
 * @Description
 * @ClassName RedPacketDistribute
 * @Author smile
 * @date 2023.03.16 11:11
 */
public class RedPacketDistribute {

    private static Random random = new Random();

    public static void main(String[] args) {
        radPacket(100, 10);
    }

    public static void radPacket(double redPackageAmount, int redPacketCount) {

        int i = 0;
        int count = redPacketCount;
        double redPacketDistributeSum = 0.00;
        for (; i < count - 1; i++) {
            double randomRedPacket = random.nextDouble() * redPackageAmount / redPacketCount * 2;
            randomRedPacket = randomRedPacket <= 0.01 ? 0.01 : randomRedPacket;
            randomRedPacket = Math.floor(randomRedPacket * 100) / 100;
            System.out.println("第" + i + "个红包的金额:" + randomRedPacket);
            redPackageAmount -= randomRedPacket;
            redPacketCount--;
            redPacketDistributeSum += randomRedPacket;
        }
        double lastRedPacket = Math.round(redPackageAmount * 100) / 100.00;
        redPacketDistributeSum += lastRedPacket;
        System.out.println("第" + i + "个红包的金额:" + lastRedPacket);
        System.out.println("发出去的金额总和为:" + Math.round(redPacketDistributeSum * 100) / 100);
    }

    public static double getRemainRedPacket(double redPackageAmount, double randomRedPacket) {
        BigDecimal result = BigDecimal.valueOf(redPackageAmount).setScale(2).subtract(BigDecimal.valueOf(randomRedPacket));
        return result.doubleValue();
    }
}
