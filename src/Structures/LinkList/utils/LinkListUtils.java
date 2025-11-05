package Structures.LinkList.utils;

public class LinkListUtils {

    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static ListNode buildList(int[] arr){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for(int num : arr){
            head.next = new ListNode(num);
            head = head.next;
        }
        return dummy.next;
    }

    public static ListNode getTail(ListNode head) {
        if (head == null) return null;
        while (head.next != null) head = head.next;
        return head;
    }

    public static ListNode[] buildIntersectedLists(int[] listA, int[] listB, int[] common) {
        ListNode commonPart = buildList(common);

        ListNode headA = buildList(listA);
        ListNode headB = buildList(listB);

        if (headA != null) {
            getTail(headA).next = commonPart;
        } else {
            headA = commonPart;
        }

        if (headB != null) {
            getTail(headB).next = commonPart;
        } else {
            headB = commonPart;
        }

        return new ListNode[]{headA, headB};
    }
}
