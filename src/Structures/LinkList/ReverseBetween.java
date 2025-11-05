package Structures.LinkList;

import Structures.LinkList.utils.ListNode;
import static Structures.LinkList.utils.LinkListUtils.*;

public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int[] nums = new int[right - left + 1];
        ListNode ptr = head;
        ListNode pre = head;
        for(int i = 1; i < left; i++){
            ptr = ptr.next;
        }
        pre = ptr;
        for(int i = left; i <= right; i++){
            nums[i - left] = ptr.val;
            ptr = ptr.next;
        }
        for(int i = nums.length - 1; i >= 0; i--){
            pre.val = nums[i];
            pre = pre.next;
        }
        return head;
    }

    public static void main(String[] args){
        ReverseBetween sol = new ReverseBetween();
        ListNode head = buildList(new int[]{1,2,3,4,5});
        sol.reverseBetween(head,2,4);
    }
}
