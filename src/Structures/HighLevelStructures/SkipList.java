package Structures.HighLevelStructures;

import java.util.Random;

public class SkipList {
    private static final int MAX_LEVEL = 32;
    private static final double P = 0.5;
    private Random random = new Random();
    private Node head = new Node(-1, MAX_LEVEL);
    private int levelCount = 1;

    static class Node {
        int value;
        Node[] next;

        Node(int value, int level) {
            this.value = value;
            this.next = new Node[level];
        }
    }


    private int randomLevel() {
        int level = 1;
        while (random.nextDouble() < P && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }

    public void insert(int value) {
        int level = randomLevel();
        Node newNode = new Node(value, level);

        Node cur = head;
        Node[] update = new Node[level];

        for (int i = levelCount - 1; i >= 0; i--) {
            while (cur.next[i] != null && cur.next[i].value < value) {
                cur = cur.next[i];
            }
            if (i < level) update[i] = cur;
        }

        if (level > levelCount) {
            for (int i = levelCount; i < level; i++) {
                update[i] = head;
            }
            levelCount = level;
        }

        for (int i = 0; i < level; i++) {
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }
    }

    public boolean contains(int value) {
        Node cur = head;

        for (int i = levelCount - 1; i >= 0; i--) {
            while (cur.next[i] != null && cur.next[i].value < value) {
                cur = cur.next[i];
            }
        }

        cur = cur.next[0];

        return cur != null && cur.value == value;
    }

    public boolean delete(int value) {
        Node cur = head;
        Node[] update = new Node[levelCount];

        for (int i = levelCount - 1; i >= 0; i--) {
            while (cur.next[i] != null && cur.next[i].value < value) {
                cur = cur.next[i];
            }
            update[i] = cur;
        }

        cur = cur.next[0];

        if (cur == null || cur.value != value) return false;

        for (int i = 0; i < levelCount; i++) {
            if (update[i].next[i] != cur) break;
            update[i].next[i] = cur.next[i];
        }

        while (levelCount > 1 && head.next[levelCount - 1] == null) {
            levelCount--;
        }

        return true;
    }
}
