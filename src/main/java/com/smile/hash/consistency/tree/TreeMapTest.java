package com.smile.hash.consistency.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Description
 * @ClassName TreeMapTest
 * @Author smile
 * @date 2020.07.11 11:06
 */
@Slf4j
public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap<Long, String> sortMap = new TreeMap<>();
        sortMap.put(4L, "192.168.23.14");
        sortMap.put(64L, "192.168.23.64");
        sortMap.put(164L, "192.168.23.164");
        sortMap.put(200L, "192.168.23.200");

        SortedMap<Long, String> last = sortMap.tailMap(250L);
        if (!last.isEmpty()) {
            log.info("结果:{}", last.get(last.firstKey()));
        } else {
            log.info("结果:{}", sortMap.firstEntry().getValue());
        }
    }
}
