package com.smile.hash.consistency;

/**
 * @Description
 * @ClassName Node
 * @Author smile
 * @date 2023.03.05 20:16
 */
public class Node {

    private Long key;

    private String ipAddress;

    public Node() {
    }

    public Node(Long key, String ipAddress) {
        this.key = key;
        this.ipAddress = ipAddress;
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }
}
