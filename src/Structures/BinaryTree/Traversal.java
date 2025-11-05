package Structures.BinaryTree;

import Structures.BinaryTree.Utils.*;

import static Structures.BinaryTree.Utils.Basics.*;

import java.util.ArrayList;
import java.util.List;


class Traversal {
    public List<Integer> Traversals(TreeNode root, String mode, List<Integer> res) {
        if (root == null) return res;

        switch (mode) {
            case "pre":
                res.add(root.val);
                Traversals(root.left, mode, res);
                Traversals(root.right, mode, res);
                break;
            case "post":
                Traversals(root.left, mode, res);
                Traversals(root.right, mode, res);
                res.add(root.val);
                break;
            case "in":
                Traversals(root.left, mode, res);
                res.add(root.val);
                Traversals(root.right, mode, res);
                break;
        }
        return res;
    }

    public static void main(String[] args) {

        Traversal traversal = new Traversal();
        System.out.println();
        printTree(tree1());
        System.out.println("preorder:\t" + traversal.Traversals(tree1(), "pre", new ArrayList<>()));
        System.out.println("postorder:\t" + traversal.Traversals(tree1(), "post", new ArrayList<>()));
        System.out.println("inorder:\t" + traversal.Traversals(tree1(), "in", new ArrayList<>()));
    }

}