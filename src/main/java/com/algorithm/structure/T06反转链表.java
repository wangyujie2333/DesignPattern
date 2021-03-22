package com.algorithm.structure;

import com.program.string.ListNode;

/**
 * @author wangyuj
 * @date 2021/1/5
 **/
public class T06反转链表 {
    static ListNode successor = null; // 后驱节点

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode listNode = 反转链表(listNode1, 2, 3);
        System.out.println(listNode);
    }

    /**
     * ListNode successor = null; // 后驱节点
     * <p>
     * // 反转以 head 为起点的 n 个节点，返回新的头结点
     * ListNode reverseN(ListNode head, int n) {
     * if (n == 1) {
     * // 记录第 n + 1 个节点
     * successor = head.next;
     * return head;
     * }
     * // 以 head.next 为起点，需要反转前 n - 1 个节点
     * ListNode last = reverseN(head.next, n - 1);
     * <p>
     * head.next.next = head;
     * // 让反转之后的 head 节点和后面的节点连起来
     * head.next = successor;
     * return last;
     * }
     */
    public static ListNode 反转链表(ListNode head) {
        if (head.next == null) return head;
        ListNode list = 反转链表(head.next);
        head.next.next = head;
        head.next = null;
        return list;
    }

    public static ListNode 反转链表(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode list = 反转链表(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return list;
    }

    public static ListNode 反转链表(ListNode head, int m, int n) {
        if (m == 1) {
            return 反转链表(head, n);
        }
        head.next = 反转链表(head.next, m - 1, n - 1);
        return head;
    }
}
