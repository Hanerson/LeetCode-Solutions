package Structures.LinkList;

import Structures.LinkList.utils.*;

import static Structures.LinkList.utils.LinkListUtils.*;

public class DeleteDuplicates {
    public ListNode deleteAllDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null) {
            boolean duplicated = false;
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
                duplicated = true;
            }
            if (duplicated) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    public static void main(String[] args){
        ListNode head = buildList(new int[]{1,1,2,2,3});
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        ListNode result = deleteDuplicates.deleteDuplicates(head);
        printList(result);
    }
}
