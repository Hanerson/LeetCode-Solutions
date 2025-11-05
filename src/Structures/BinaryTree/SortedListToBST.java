package Structures.BinaryTree;

import Structures.BinaryTree.Utils.TreeNode;
import Structures.LinkList.utils.ListNode;

public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head){
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);

        ListNode slow = head, prev = null;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) prev.next = null;

        TreeNode root = new TreeNode(slow.val);

        root.left = sortedListToBST(head == slow ? null : head);

        ListNode newHead = slow.next;
        slow.next = null;

        root.right = sortedListToBST(newHead);

        return root;
    }
}
