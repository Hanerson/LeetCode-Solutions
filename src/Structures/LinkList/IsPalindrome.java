package Structures.LinkList;

import Structures.LinkList.utils.*;

import static Structures.LinkList.utils.LinkListUtils.buildList;

public class IsPalindrome {
    public boolean isPalindrome(ListNode head){
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast == null){
            fast = head;
        }else{
            fast = head;
            slow = slow.next;
        }
        slow = reverse(slow);
        while(slow != null){
            if(slow.val != fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
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
        IsPalindrome solution = new IsPalindrome();
        ListNode List = buildList(new int[]{1,2,3,4,5,4,3,2,1});
        System.out.println(solution.isPalindrome(List));
    }
}
