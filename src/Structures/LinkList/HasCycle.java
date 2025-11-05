package Structures.LinkList;

import Structures.LinkList.utils.ListNode;

public class HasCycle {
    public boolean  hasCycle(ListNode head){
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if(fast.next == null || fast.next.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
