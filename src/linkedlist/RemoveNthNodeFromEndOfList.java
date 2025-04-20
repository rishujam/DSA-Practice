package linkedlist;

import linkedlist.util.ListNode;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        //T1
        ListNode input = new ListNode(1);
        input.next = new ListNode(2);
        input.next.next = new ListNode(3);
        input.next.next.next = new ListNode(4);
        input.next.next.next.next = new ListNode(5);

        //T2
        ListNode input2 = new ListNode(1);
        input2.next = new ListNode(2);
        ListNode output = ans2(input2, 1);
        while(output != null) {
            System.out.print(output.val + "->");
            output = output.next;
        }
    }

    static ListNode ans(ListNode head, int n) {
        ListNode current = head;
        int size = 0;
        while(current != null) {
            current = current.next;
            size++;
        }
        int positionToStop = size - n;
        if(positionToStop == 0) {
            return head.next;
        }
        current = head;
        for(int i = 1; i < positionToStop; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }

    static ListNode ans2(ListNode head, int n) {
        ListNode iterator = new ListNode(0);
        iterator.next = head;
        ListNode fast = iterator;
        ListNode slow = iterator;
        for(int i=0; i<=n; i++) {
            fast = fast.next;
        }
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return iterator.next;
    }

}
