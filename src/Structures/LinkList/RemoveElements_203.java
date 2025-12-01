package Structures.LinkList;

import Structures.LinkList.utils.ListNode;

import static Structures.LinkList.utils.LinkListUtils.*;

public class RemoveElements_203 {
    public ListNode removeElements(ListNode head, int val) {
        while(head != null &&  head.val == val){
            head = head.next;
        }
        if(head == null || head.next == null) return head;

        ListNode ptr = head.next, prev = head;
        while(prev.next != null){
            while(ptr != null && ptr.val == val){
                ptr = ptr.next;
            }
            prev.next = ptr;
            prev = prev.next;
            if(ptr != null) ptr = ptr.next;
            else return head;
        }
        return head;
    }

    public static void main(String[] args){
        RemoveElements_203 obj = new RemoveElements_203();
        ListNode list = buildList(new int[]{1,2,6,3,4,5,6});
        printList(obj.removeElements(list, 6));
    }
}
