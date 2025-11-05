package Structures.HighLevelStructures.BTree;

import java.util.ArrayList;
import java.util.List;

public class BTreeNode {
    boolean isLeaf;
    List<Integer> keys;
    List<BTreeNode> children;
    public BTreeNode(boolean isLeaf){
        this.isLeaf = isLeaf;
        keys = new ArrayList<>();
        children = new ArrayList<>();
    }
}
