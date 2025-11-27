package Structures.HighLevelStructures.PriorityQueue;

import java.util.*;

public class HeapWithDecrease {
    static int MAX = 10000005;

    static int[] heap = new int[MAX];
    static int size = 0;

    static HashMap<Integer, Integer> map = new HashMap<>();
    static int[] insertedValue = new int[MAX];
    static int pushCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] ops = line.split(" ");

            switch (ops[0]) {
                case "push":
                    int x = Integer.parseInt(ops[1]);
                    push(x);
                    break;

                case "pop":
                    pop();
                    break;

                case "top":
                    System.out.println(heap[1]);
                    break;

                case "size":
                    System.out.println(size);
                    break;

                case "decrease":
                    int i = Integer.parseInt(ops[1]);
                    int k = Integer.parseInt(ops[2]);
                    decrease(i, k);
                    break;
            }
        }
    }

    private static void push(int num) {
        heap[++size] = num;
        map.put(num, size);

        insertedValue[++pushCount] = num;

        siftUp(size);
    }

    private static void pop() {
        int topVal = heap[1];

        map.remove(topVal);

        int lastVal = heap[size];
        heap[1] = lastVal;
        size--;

        if (size > 0) {
            map.put(lastVal, 1);
            siftDown(1);
        }
    }

    private static void siftUp(int pos) {
        while (pos > 1) {
            int parent = pos / 2;
            if (heap[pos] < heap[parent]) {
                swap(pos, parent);
                pos = parent;
            } else break;
        }
    }

    private static void siftDown(int pos) {
        while (pos * 2 <= size) {
            int left = pos * 2;
            int right = left + 1;
            int smallest = left;

            if (right <= size && heap[right] < heap[left]) {
                smallest = right;
            }

            if (heap[smallest] < heap[pos]) {
                swap(pos, smallest);
                pos = smallest;
            } else break;
        }
    }

    private static void swap(int a, int b) {
        int va = heap[a];
        int vb = heap[b];

        heap[a] = vb;
        heap[b] = va;

        map.put(vb, a);
        map.put(va, b);
    }

    private static void decrease(int pushId, int newVal) {
        int oldVal = insertedValue[pushId];
        insertedValue[pushId] = newVal;

        int pos = map.get(oldVal);
        map.remove(oldVal);

        heap[pos] = newVal;
        map.put(newVal, pos);

        siftUp(pos);
    }
}
