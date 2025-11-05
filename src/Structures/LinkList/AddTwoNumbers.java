package Structures.LinkList;

import Structures.LinkList.utils.ListNode;

import static Structures.LinkList.utils.LinkListUtils.*;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, sum;
        ListNode head=new ListNode(0);
        ListNode ptr=head;
        while (l1 != null && l2 != null){
            sum=carry+l1.val+l2.val;
            carry=sum/10;
            sum=sum%10;
            head.next=new ListNode(sum);
            head=head.next;
            l1=l1.next;
            l2=l2.next;
        }
        while (l1 != null){
            sum=carry+l1.val;
            carry=sum/10;
            sum=sum%10;
            head.next=new ListNode(sum);
            head=head.next;
            l1=l1.next;
        }
        while (l2 != null){
            sum=carry+l2.val;
            carry=sum/10;
            sum=sum%10;
            head.next=new ListNode(sum);
            head=head.next;
            l2=l2.next;
        }
        if(carry>0){
            head.next=new ListNode(carry);
        }
        return ptr.next;
    }
    public static void main(String[] args){
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(9);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(9);
        ListNode l3 = addTwoNumbers.addTwoNumbers(l1, l2);
        printList(l3);
    }
}