package b.mid;

import java.util.Objects;
import java.util.Optional;

/**
 * @author ziqing
 * @date 2024/1/8 17:00
 */
@SuppressWarnings("all")
public class 两数相加 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //这个地方需要注意，对于链表需要有头结点和尾节点
        ListNode head = null,tail = null;
        ListNode n1 = l1;
        ListNode n2 = l2;
        int carry = 0;
        //循环至两个链表都不为空结束
        while (n1 != null || n2 != null) {
            int add1 = n1 == null ? 0 : n1.val;
            int add2 = n2 == null ? 0 : n2.val;
            int sum = add1 + add2 + carry;

            carry = sum / 10;
            //如果产生了进位则需要记录
            if (carry > 0) {
                sum = sum % 10;
            }
            //如果头结点为空则需要初始化
            if (head == null) {
                head = tail = new ListNode(sum);
            } else {
                //先讲当前的尾结点进行赋值
                tail.next = new ListNode(sum);
                //将尾结点向后移动
                tail = tail.next;
            }

            //向下移动
            n1 = n1 == null ? null : n1.next;
            n2 = n2 == null ? null : n2.next;
            //如果出现进位先占坑，防止最后一个进位没有处理，导致丢失
            if (carry > 0) {
                tail.next = new ListNode(carry);
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        ListNode addSum = addTwoNumbers(l1, l2);

        System.out.println(addSum.toString());
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
