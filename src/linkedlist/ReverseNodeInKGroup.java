package linkedlist;

import linkedlist.util.DataGen;
import linkedlist.util.ListNode;

public class ReverseNodeInKGroup {

    public static void main(String[] args) {
        //T1
        ListNode input = new ListNode(1);
        input.next = new ListNode(2);
//        input.next.next = new ListNode(3);
//        input.next.next.next = new ListNode(4);
//        input.next.next.next.next = new ListNode(5);
        ListNode out = reverseKGroup(input, 2);
        DataGen.printLinkedList(out);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        int size = 0;
        ListNode sizeHead = head;
        while(sizeHead != null) {
            sizeHead = sizeHead.next;
            size++;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        if(head == null || head.next == null) return head;

        int noOfGroups = size / k;
        ListNode subListHead = head;
        ListNode kThNode = head;
        ListNode tail = dummy;
        for(int i = 1; i <= noOfGroups; i++) {
            for(int j = 1; j < k; j++) {
                kThNode = kThNode.next;
            }
            ListNode nextSubListHead = kThNode.next;
            kThNode.next = null;
            ListNode reversedHead = reverse(subListHead);
            tail.next = reversedHead;
            subListHead.next = nextSubListHead;
            tail = subListHead;
            subListHead = nextSubListHead;
            kThNode = nextSubListHead;
        }
        return dummy.next;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

}
