package com.smile.hash.consistency;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * hash环
 *
 * @Description
 * @ClassName SortHashMap
 * @Author smile
 * @date 2023.03.05 20:17
 */
@Slf4j
public class SortHashMap {

    private Node[] buckets;

    private int DEFAULT_SIZE = 8;

    private int size = 0;

    public SortHashMap() {
        buckets = new Node[DEFAULT_SIZE];
    }

    public void add(Long key, String ipAddress) {
        checkSize();
        buckets[size++] = new Node(key, ipAddress);
    }

    public void checkSize() {
        int length = buckets.length;
        if (size >= length) {
            int newLength = length + length >> 2;
            buckets = Arrays.copyOf(buckets, newLength);
        }
    }

    public void sort() {
        Arrays.sort(buckets, 0, size, Comparator.comparing(Node::getKey));
    }

    public String getAdjoinNode(Long key) {
        String ipAddress = null;
        if (size == 0) {
            return ipAddress;
        }
        Optional<Node> first = Stream.of(buckets).filter(e -> e != null && e.getKey() >= key).findFirst();
        if (first.isPresent()) {
            return first.get().getIpAddress();
        }
        return buckets[0].getIpAddress();
    }

    public static void main(String[] args) {
        SortHashMap sortHashMap = new SortHashMap();
        sortHashMap.add(2L, "192.168.2.2");
        sortHashMap.add(213L, "192.168.2.213");
        sortHashMap.add(28L, "192.168.2.28");
        sortHashMap.add(122L, "192.168.2.122");
        sortHashMap.add(72L, "192.168.2.72");

        sortHashMap.sort();
        log.info("排序的结果:{}", sortHashMap);
        log.info("对应的节点值:{}", sortHashMap.getAdjoinNode(188L));
        log.info("对应的节点值:{}", sortHashMap.getAdjoinNode(288L));
    }
}
