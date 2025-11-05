package Structures.LinkList;

import Structures.LinkList.utils.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Structures.LinkList.utils.LinkListUtils.*;

public class MergeLists {
    public ListNode mergeLists(ListNode[] Lists){
        int count = 0;
        int minIndex = 0;
        ListNode dummy = new ListNode(0), head = dummy;
        boolean[] deleted =  new boolean[Lists.length];
        List<ListNode> lists = new  ArrayList<>();
        Collections.addAll(lists, Lists);
        while(count<Lists.length){
            for(int i=0;i<lists.size();i++){
                if(deleted[i] || lists.get(i) == null){
                    continue;
                }
                if(lists.get(minIndex) == null || lists.get(i).val <= lists.get(minIndex).val){
                    minIndex = i;
                }
            }
            if(lists.get(minIndex)!=null) {
                head.next = new ListNode(lists.get(minIndex).val);
                head = head.next;
                lists.set(minIndex, lists.get(minIndex).next);
            }else{
                deleted[minIndex] = true;
                count++;
            }
        }
        return dummy.next;
    }
    public static void main(String[] args){
        MergeLists sol = new MergeLists();
        ListNode[] lists = new ListNode[3];
        lists[0] = buildList(new int[]{1,4,5});
        lists[1] = buildList(new int[]{1,3,4});
        lists[2] = buildList(new int[]{2,6});
        printList(sol.mergeLists(lists));
    }
}
