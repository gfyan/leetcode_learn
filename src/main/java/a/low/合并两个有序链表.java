package a.low;

import java.util.Objects;
import java.util.Optional;

/**
 * @author ziqing
 * @date 2024/1/9 22:37
 */
@SuppressWarnings("all")
public class 合并两个有序链表 {

    /**
     * 关键字「链表、递归」
     *
     * 题目描述：
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * ===================
     *
     * @param list1 链表1
     * @param list2 链表2
     * @return 合并后的链表
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 若任一链表是空链表，则直接返回非空链表
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            // 若list1的头节点较小，则将list1的头节点与剩下元素和list2合并的结果相连
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            // 若list2的头节点较小，则将list2的头节点与剩下元素和list1合并的结果相连
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode listNode = mergeTwoLists(list1, list2);
        System.out.println(listNode);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {this.val = val;}

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "" + this.val + "" + Optional.ofNullable(this.next).map(Objects::toString).orElse("");
        }
    }
}
