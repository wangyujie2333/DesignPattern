package com.program.string;

import java.util.*;

/**
 * @Description:数据结构
 * @Author: WangYuJ
 * @Date 2018/3/13
 */
public class DateStructure001 {

    public int minNum(int[] numbers) {
        if (numbers.length == 0) return 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > numbers[i + 1]) return numbers[i + 1];
        }
        return 0;
    }

    /**
     * @Todo: 斐波那契数列
     * @Date 2018/3/13 19:06
     * @Param
     * @Return
     */
    public static int[] fib = new int[40];

    public static int[] getfib(int[] fib) {
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < fib.length; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }

    /**
     * @Todo: 两个栈实现队列
     * @Date 2018/3/13 18:58
     * @Param
     * @Return
     */
    public Stack<Integer> stack1 = new Stack<>();
    public Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /**
     * @Todo: 根据前序遍历和中序遍历，实现二叉树的反转
     * @Date 2018/3/13 18:51
     * @Param [pre, mid]
     * @Return com.program.string.TreeNode
     */
    public static TreeNode getTreeNode(int[] pre, int[] mid) {
        return getTreeNode(pre, 0, pre.length - 1, mid, 0, mid.length - 1);
    }

    private static TreeNode getTreeNode(int[] pre, int prel, int prer, int[] mid, int midl, int midr) {
        if (prel == prer) return new TreeNode(pre[prel]);
        if (prel > prer || midl > midr) return null;
        TreeNode root = new TreeNode(pre[prel]);
        int midsize = midl;
        while (midsize < midr && pre[prel] != mid[midsize]) {
            midsize++;
        }
        int leftsize = midsize - midl;
        root.left = getTreeNode(pre, prel + 1, prel + leftsize, mid, midl, midl + leftsize - 1);
        root.right = getTreeNode(pre, prel + leftsize + 1, prer, mid, midl + leftsize + 1, midr);
        return root;
    }

    /**
     * @Todo: 使用栈先进后出的特点
     * @Date 2018/3/13 17:04
     * @Param [listNode]
     * @Return java.util.Stack<java.lang.Integer>
     */
    public static Stack<Integer> reverseByStack(ListNode listNode) {
        Stack<Integer> ret = new Stack<>();
        while (listNode != null) {
            ret.push(listNode.getVal());
            listNode = listNode.getNext();
        }
        System.out.println(ret.pop());
        return ret;
    }

    /**
     * @Todo: 使用集合工具Collections.reverse()方法
     * @Date 2018/3/13 17:05
     * @Param [listNode]
     * @Return java.util.ArrayList<java.lang.Integer>
     */
    public static ArrayList<Integer> getReverse(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        while (listNode != null) {
            ret.add(listNode.getVal());
            listNode = listNode.getNext();
        }
        Collections.reverse(ret);
        return ret;
    }

    public static void main(String[] args) {
        getfib(fib);

    }
}
