package linkedlist;

import linkedlist.util.ListNode;

public class DetectCycle2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode newNode = new ListNode(2);
        head.next = newNode;
        newNode.next = head;
        System.out.println(detectCycle(head).val);
    }

    public static ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        if(head.next == null) {
            return null;
        }
        if(head.next.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        var isCycle = false;
        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == null) {
                return null;
            }
            if(slow == fast) {
                isCycle = true;
                break;
            }
        }
        if(!isCycle) return null;
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
