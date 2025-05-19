package linkedlist;

import linkedlist.util.DataGen;
import linkedlist.util.ListNode;

import java.util.Random;

public class Add2Number {

    public static void main(String[] args) {
        //T1
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        //T2
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        ListNode out = addTwoNumbers(l1, l2);
        DataGen.INSTANCE.printLinkedList(out);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode out = new ListNode(0);
        ListNode toReturn = out;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int first = 0;
            int second = 0;
            if(l1 != null) {
                first = l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                second = l2.val;
                l2 = l2.next;
            }
            int sum = first + second + carry;
            carry = sum / 10;
            out.next = new ListNode(sum % 10);
            out = out.next;
        }
        return toReturn.next;
    }

}
