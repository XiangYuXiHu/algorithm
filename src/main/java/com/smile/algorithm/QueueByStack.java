package com.smile.algorithm;

import java.util.Stack;

/**
 * @Description
 * @ClassName QueueByStack
 * @Author smile
 * @date 2023.08.06 06:12
 */
public class QueueByStack<T> {

    private Stack<T> in = new Stack<>();
    private Stack<T> out = new Stack<>();

    public void add(T e) {
        in.push(e);
    }

    public T pop() {
        if (!out.isEmpty()) {
            return out.pop();
        } else {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
            return out.pop();
        }
    }

    /**
     * 返回队列开头的元素
     *
     * @return
     */
    public T peek() {
        if (!out.isEmpty()) {
            return out.peek();
        } else {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
            return out.peek();
        }
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    public static void main(String[] args) {
        QueueByStack<Integer> queueByStack = new QueueByStack<>();
        for (int i = 0; i < 5; i++) {
            queueByStack.add(i);
        }

        for (int i = 0; i < 3; i++) {
            Integer remove = queueByStack.pop();
            System.out.println(remove);
        }

        for (int i = 0; i < 3; i++) {
            queueByStack.add(10 + i);
        }

        for (int i = 0; i < 5; i++) {
            Integer remove = queueByStack.pop();
            System.out.println(remove);
        }

    }

}
