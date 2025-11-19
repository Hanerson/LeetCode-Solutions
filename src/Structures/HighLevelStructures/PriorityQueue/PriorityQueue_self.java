package Structures.HighLevelStructures.PriorityQueue;

public class PriorityQueue_self {
    int[] heap;
    int size;

    public PriorityQueue_self(int capacity){
        this.heap = new int[capacity];
        this.size = 0;
    }

    public void insert(int val){
        if(size == heap.length - 1){
            throw new IllegalArgumentException("heap is full");
        }
        size ++;
        heap[size] = val;
        int tempPos = size;
        while(tempPos > 1 && heap[tempPos] < heap[tempPos/2]){
            swap(tempPos, tempPos/2);
            tempPos /= 2;
        }
    }

    public void insert(int[] arr){
        for(int num : arr){
            insert(num);
        }
    }

    public int poll() {
        if (size == 0) {
            throw new IllegalArgumentException("PriorityQueue is empty");
        }

        int top = heap[1]; // 如果想返回堆顶，保留这行

        heap[1] = heap[size]; // 最后一个补上来
        size--;

        int k = 1;

        while (2 * k <= size) {  // 左孩子存在
            int left = 2 * k;
            int right = left + 1;
            int child = left;

            // 右孩子存在并且更小 → 选择右孩子
            if (right <= size && heap[right] < heap[left]) {
                child = right;
            }

            // 当前节点比孩子小 → 停止
            if (heap[k] <= heap[child]) break;

            // 下沉
            swap(k, child);
            k = child;
        }

        return top;
    }

    private void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void printRaw(){
        for(int i = 1; i <= size; i++){
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public void printOrder() {
        PriorityQueue_self tmp = new PriorityQueue_self(heap.length);
        for (int i = 1; i <= size; i++) {
            tmp.insert(heap[i]);
        }
        while (tmp.size > 0) {
            System.out.print(tmp.poll() + " ");
        }
    }


    public static void main(String[] args){
        PriorityQueue_self pq = new PriorityQueue_self(10);

        pq.insert(new int[]{1,4,2,3,6,2,7,9});

        pq.printRaw();
        pq.printOrder();
    }
}
