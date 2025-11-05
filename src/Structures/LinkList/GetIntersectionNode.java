package Structures.LinkList;
import Structures.LinkList.utils.ListNode;

import static Structures.LinkList.utils.LinkListUtils.*;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        while (ptrA != ptrB) {
            ptrA = (ptrA == null) ? headB : ptrA.next;
            ptrB = (ptrB == null) ? headA : ptrB.next;
        }
        return ptrA;
    }

    public static void main(String[] args){

        GetIntersectionNode solution = new GetIntersectionNode();

        int[] List1 = new int[]{1,2,3,4,5};
        int[] List2 = new int[]{4,5,1,2};
        ListNode headA = buildList(List1);
        ListNode headB = buildList(List2);

        int[] common = new int[]{5,6,7};
        ListNode[] Nodes = buildIntersectedLists(List1, List2, common);

        System.out.println(solution.getIntersectionNode(headA,headB)==null?"nothing intersected":solution.getIntersectionNode(headA,headB));

        System.out.println(solution.getIntersectionNode(Nodes[0],Nodes[1])==null?"nothing intersected":solution.getIntersectionNode(Nodes[0],Nodes[1]));

    }
}
