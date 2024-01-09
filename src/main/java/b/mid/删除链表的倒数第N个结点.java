package b.mid;

import java.util.Objects;
import java.util.Optional;

/**
 * @author ziqing
 * @date 2024/1/9 21:25
 */
@SuppressWarnings("all")
public class 删除链表的倒数第N个结点 {

    /**
     * 关键字「链表、双指针」
     *
     * 题目描述：
     * 给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     *
     * @param head 链表头结点
     * @param n    倒数第n个结点
     * @return 删除后的链表
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //因为要返回头结点，所以需要把头结点记录下来
        //设置一个哑结点，用于处理边界情况
        ListNode dummy = new ListNode(0, head);
        //设置两个指针
        ListNode first = dummy, second = dummy;
        // 将第一个指针向前移动n+1步
        for (int i = 0; i <= n; i++) {
            if (first == null) {
                return dummy.next;
            }
            first = first.next;
        }

        // 现在第一个指针和第二个指针相距n个节点
        // 当第一个指针到达链表末尾时，第二个指针将指向倒数第n个节点的前一个节点
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        //删除节点
        ListNode delNode = second.next;
        second.next = delNode.next;
        delNode = null;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        ListNode resultNode = removeNthFromEnd(listNode, 2);
        System.out.println(resultNode);
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
