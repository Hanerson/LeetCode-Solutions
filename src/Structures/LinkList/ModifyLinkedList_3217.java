package Structures.LinkList;

import Structures.LinkList.utils.ListNode;

import java.util.HashSet;
import java.util.Set;

public class ModifyLinkedList_3217 {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode ptr = dummyHead;

        while (ptr.next != null){
            if(set.contains(ptr.next.val)){
                ptr.next = ptr.next.next;
            }else ptr =  ptr.next;
        }

        return dummyHead.next;
    }
}