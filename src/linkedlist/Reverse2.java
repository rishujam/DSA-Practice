package linkedlist;

import linkedlist.util.DataGen;
import linkedlist.util.ListNode;

public class Reverse2 {

    public static void main(String[] args) {
        //T1
//        ListNode input = new ListNode(1);
//        input.next = new ListNode(2);
//        input.next.next = new ListNode(3);
//        input.next.next.next = new ListNode(4);
//        input.next.next.next.next = new ListNode(5);
//        ListNode out = reverseBetween(input, 2, 4);
        //t2
        ListNode input = new ListNode(3);
        input.next = new ListNode(5);
        ListNode out = reverseBetween2(input, 1, 2);
        DataGen.printLinkedList(out);
    }

    public static ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode leftPre = dummy;
        for(int i = 0; i < left - 1; i++) {
            leftPre = leftPre.next;
        }

        ListNode curr = leftPre.next;
        ListNode subListHead = curr;

        ListNode preNode = null;
        for(int i = 0; i <= (right - left); i++) {
            ListNode next = curr.next;
            curr.next = preNode;
            preNode = curr;
            curr = next;
        }
        leftPre.next = preNode;
        subListHead.next = curr;
        return dummy.next;
    }
}
