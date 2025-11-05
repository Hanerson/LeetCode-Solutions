package Structures.LinkList;

import Structures.LinkList.utils.*;

import java.util.Random;

import static Structures.LinkList.utils.LinkListUtils.*;

public class SortList {
    public ListNode sortList_bubble(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode ptr = head;
        while(ptr.next != null){
            ListNode temp = head;
            while(temp.next != null){
                if(temp.next.val < temp.val){
                    swap(temp,temp.next);
                }
                temp=temp.next;
            }
            ptr=ptr.next;
        }
        return head;
    }

    public void swap(ListNode node1, ListNode node2){
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    public ListNode sortList_standard(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l1 = sortList_standard(head);
        ListNode l2 = sortList_standard(slow);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }

    public int[] generateRandomArray(int n, int min, int max) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(max - min + 1) + min; // [min, max]
        }
        return arr;
    }

    public static void main(String[] args){
        SortList solution = new SortList();
        int[] ref = solution.generateRandomArray(50000,0,5000);
        long start1 = System.nanoTime();
        ListNode L1 = solution.sortList_bubble(buildList(ref));
        long end1 = System.nanoTime();
        System.out.println("bubbling sort: " + (end1 - start1) / 1_000_000.0 + " ms");

        long start2 = System.nanoTime();
        ListNode L2 = solution.sortList_standard(buildList(ref));
        long end2 = System.nanoTime();
        System.out.println("merging sort: " + (end2 - start2) / 1_000_000.0 + " ms");
    }
}
