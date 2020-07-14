package com.program.string;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description:
 * @Author: WangYuJ
 * @Date 2018/6/11
 */
public class StackToQueue {
    private Stack<String> in = new Stack<>();
    private Stack<String> out = new Stack<>();

    public void push(String string) {
        in.push(string);
    }

    public String pop() {
        in2out();
        return out.pop();
    }

    private void in2out() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }
}
class QueueToStack{
    private Queue<String> queue = new LinkedList();

    public void push(String string) {
        queue.add(string);
        toStack();
    }

    private void toStack() {
        Integer size = queue.size();
        while (size-- > 1) {
            queue.add(queue.poll());
        }
    }

    public String pop() {
        return queue.poll();
    }
}
