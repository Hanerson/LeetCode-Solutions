package Structures.LinkList;
import Structures.LinkList.utils.*;

import static Structures.LinkList.utils.LinkListUtils.*;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static void main(String[] args){
        ReverseList solution = new ReverseList();
        ListNode List = buildList(new int[]{1,2,3,4,5});
        List =  solution.reverseList(List);
        printList(List);
    }
}
