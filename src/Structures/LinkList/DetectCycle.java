package Structures.LinkList;

import Structures.LinkList.utils.ListNode;

public class DetectCycle{
    public ListNode detectCycle_abnormal(ListNode head){
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if(fast.next == null || fast.next.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode ptrA = head;
        ListNode ptrB = fast.next;
        while (ptrA != ptrB) {
            ptrA = (ptrA == slow) ? fast.next : ptrA.next;
            ptrB = (ptrB == slow) ? head : ptrB.next;
        }
        return ptrA;
    }

    public ListNode Floyd(ListNode head){
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) return null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
/*
* the Floyd method is a standard method to detect whether there is a cycle in a single linklist
* */
}
