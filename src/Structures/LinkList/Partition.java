package Structures.LinkList;

import Structures.LinkList.utils.*;

import static Structures.LinkList.utils.LinkListUtils.*;

public class Partition {
    public ListNode partition(ListNode head, int x) {
        ListNode supper = new ListNode(0), slower = new ListNode(0);
        ListNode newHead = slower, temp = supper;
        ListNode ptr = head;
        while(ptr!= null){
            if(ptr.val < x){
                slower.next = new ListNode(ptr.val);
                slower = slower.next;
            }else{
                supper.next = new ListNode(ptr.val);
                supper = supper.next;
            }
            ptr = ptr.next;
        }
        slower.next = temp.next;
        return newHead.next;
    }

    public static void main(String[] args){
        Partition sol =  new Partition();
        int[] arr = new int[]{1,4,3,2,5,2};

        ListNode head = buildList(arr);
        printList(sol.partition(head,3));
    }
}
