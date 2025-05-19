package linkedlist;

import linkedlist.util.DataGen;
import linkedlist.util.ListNode;

public class RotateList {

    public static void main(String[] args) {
        ListNode out = rotateRight(DataGen.getSize2LinkedList(), 5);
        DataGen.printLinkedList(out);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        int size = 0;
        ListNode sizeHead = head;
        while(sizeHead != null) {
            sizeHead = sizeHead.next;
            size++;
        }
        if(k > size) {
            k = k % size;
        }
        if(k == 0 || k == size) return head;
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 1; i <= k; i++) {
            fast = fast.next;
        }
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }

}
