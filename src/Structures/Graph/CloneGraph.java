package Structures.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        Node originClone = new Node();

        Queue<Node> refQueue = new LinkedList<>();
        Queue<Node> cloneQueue = new LinkedList<>();
        refQueue.offer(node);
        cloneQueue.offer(originClone);

        while(!refQueue.isEmpty()){
            Node temp = refQueue.poll();
            Node cloneTemp = cloneQueue.poll();

            cloneTemp.val = temp.val;

            cloneTemp.neighbors = new ArrayList<>();

            for(Node n : temp.neighbors){
                refQueue.offer(n);
                cloneQueue.offer(new Node());
                cloneTemp.neighbors.add(new Node(n.val));
            }
        }

        return originClone;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
