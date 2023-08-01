package com.smile.algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * 队列模拟栈
 * <p>
 * * 两个队列实现一个栈
 * * 压入：将元素放进有元素的队列中
 * * 弹出：将有元素的队列全部移除到没有元素的队列中，获取最后一个元素
 *
 * @Description
 * @ClassName StackByQueue
 * @Author smile
 * @date 2023.07.31 23:43
 */
public class StackByQueue<T> {

    private LinkedList<T> queue1 = new LinkedList<>();

    private LinkedList<T> queue2 = new LinkedList<>();

    public void push(T elem) {
        if (!queue1.isEmpty()) {
            queue1.add(elem);
        } else {
            queue2.add(elem);
        }
    }

    public T pop() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            return null;
        }
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                T elem = queue1.remove();
                queue2.add(elem);
            }
            return queue1.remove();
        } else {
            while (queue2.size() > 1) {
                T elem = queue2.remove();
                queue1.add(elem);
            }
            return queue2.remove();
        }
    }

    public static void main(String[] args) {
        StackByQueue stackByQueue = new StackByQueue();
        for (int i = 0; i < 5; i++) {
            stackByQueue.push(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(stackByQueue.pop());
        }
    }
}
