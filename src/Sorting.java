import java.util.ArrayList;
import java.util.List;

public class Sorting {

    /**
     * firstly we will realize four basic sorting algorithms
     * */

    public static class BubbleSort {

        public void bubbleSort(int[] nums) {
            int n = nums.length;

            for (int i = 0; i < n - 1; i++) {
                boolean sorted = true;

                for (int j = 0; j < n - i - 1; j++) {
                    if (nums[j] > nums[j + 1]) {
                        swap(nums, j, j + 1);
                        sorted = false;
                    }
                }

                if (sorted) break;
            }
        }

        private void swap(int[] a, int i, int j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }

    public static class SelectionSort {
        public void selectionSort(int[] nums) {
            for(int i  = 0; i < nums.length; i++){
                int leftMin = findMin(nums, i);
                swap(nums, i, leftMin);
            }
        }

        private int findMin(int[] nums, int L){
            int minIndex = L;
            for(int i = L; i < nums.length; i++){
                if(nums[i] < nums[minIndex]){
                    minIndex = i;
                }
            }
            return minIndex;
        }

        private void swap(int[] a, int i, int j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }

    public static class InsertionSort {
        public void insertionSort(int[] nums) {
            for (int i = 1; i < nums.length; i++) {

                int key = nums[i];
                int j = i - 1;

                while (j >= 0 && nums[j] > key) {
                    nums[j + 1] = nums[j];
                    j--;
                }

                nums[j + 1] = key;
            }
        }
    }

    public static class ShellSort {
        public static void shellSort(int[] arr) {
            if (arr == null || arr.length <= 1) {
                return;
            }
            int n = arr.length;
            for (int gap = n / 2; gap > 0; gap /= 2) {
                for (int i = gap; i < n; i++) {
                    int current = arr[i];
                    int j = i - gap;

                    while (j >= 0 && arr[j] > current) {
                        arr[j + gap] = arr[j];
                        j -= gap;
                    }
                    arr[j + gap] = current;
                }
            }
        }
    }

    /**
     * OK, we are starting to realize some more advanced sorting algorithms...
     * */

    public static class MergeSort {

        public static void mergeSort(int[] arr) {
            if (arr == null || arr.length <= 1) return;
            int[] temp = new int[arr.length];
            split(arr, 0, arr.length - 1, temp);
        }

        private static void split(int[] arr, int left, int right, int[] temp) {
            if (left >= right) {
                return;
            }
            int mid = left + (right - left) / 2;

            split(arr, left, mid, temp);
            split(arr, mid + 1, right, temp);

            merge(arr, left, mid, right, temp);
        }

        private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
            int i = left;
            int j = mid + 1;
            int k = left;
            while (i <= mid && j <= right) {
                if (arr[i] <= arr[j]) {
                    temp[k++] = arr[i++];
                } else {
                    temp[k++] = arr[j++];
                }
            }

            while (i <= mid) {
                temp[k++] = arr[i++];
            }

            while (j <= right) {
                temp[k++] = arr[j++];
            }

            if (right + 1 - left >= 0) System.arraycopy(temp, left, arr, left, right + 1 - left);
        }
    }

    public static class QuickSort{
        public void quickSort(int[] arr){
            sortHelper(arr, 0, arr.length-1);
        }

        private void sortHelper(int[] arr, int L, int R){
            if(L >= R) return;
            int pivot = partition(arr, L, R);

            sortHelper(arr, L, pivot);
            sortHelper(arr, pivot + 1, R);
        }

        private int partition(int[] arr, int L, int R){
            int pivot = arr[L];

            int i = L - 1,  j = R + 1;

            while(i < j){
                do { i ++; } while(arr[i] < pivot);
                do { j --; } while(arr[j] > pivot);

                if(i >= j) break;
                swap(arr, i, j);
            }

            return j;
        }

        private void swap(int[] arr, int i, int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static class HeapSort {
        public static void heapSort(int[] arr) {
            if (arr == null || arr.length <= 1) return;
            int n = arr.length;

            for (int i = n / 2 - 1; i >= 0; i--) {
                siftDown(arr, i, n);
            }

            for (int end = n - 1; end > 0; end--) {
                swap(arr, 0, end);
                siftDown(arr, 0, end);
            }
        }

        private static void siftDown(int[] arr, int index, int size) {
            int largest = index;
            while (true) {
                int left = 2 * index + 1;
                int right = left + 1;

                if (left < size && arr[left] > arr[largest]) {
                    largest = left;
                }
                if (right < size && arr[right] > arr[largest]) {
                    largest = right;
                }

                if (largest == index) break;

                swap(arr, index, largest);
                index = largest;
            }
        }
        private static void swap(int[] arr, int i, int j) {
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }

    /**
     * now we will enter the quickest sorting algorithms
     * */

    public static class CountingSort {
        public void countingSort_unStable(int[] nums){
            if (nums == null || nums.length <= 1) return;

            int max = nums[0];
            for (int num : nums) max = Math.max(max, num);

            int[] count = new int[max + 1];

            // 计数
            for (int num : nums) count[num]++;

            // 写回
            int pos = 0;
            for (int i = 0; i <= max; i++){
                while (count[i] > 0){
                    nums[pos++] = i;
                    count[i]--;
                }
            }
        }

        public void countingSort_stable(int[] nums) {
            if (nums == null || nums.length <= 1) return;

            int max = nums[0];
            for (int num : nums) max = Math.max(max, num);

            int[] count = new int[max + 1];
            for (int num : nums) {
                count[num]++;
            }

            for (int i = 1; i <= max; i++) {
                count[i] += count[i - 1];
            }

            int[] output = new int[nums.length];
            for (int i = nums.length - 1; i >= 0; i--) {
                int value = nums[i];
                int pos = count[value] - 1;
                output[pos] = value;
                count[value]--;
            }

            System.arraycopy(output, 0, nums, 0, nums.length);
        }
    }

    public static class RadixSort{
        public void radixSort(int[] arr) {
            if (arr == null || arr.length <= 1) return;

            List<Integer>[] buckets = new ArrayList[10];
            for (int i = 0; i < 10; i++) buckets[i] = new ArrayList<>();

            int divisor = 1;
            boolean hasMoreDigit = true;

            while (hasMoreDigit) {
                hasMoreDigit = false;

                for (int num : arr) {
                    int digit = (num / divisor) % 10;
                    buckets[digit].add(num);

                    if (num / divisor > 0) hasMoreDigit = true;
                }

                int idx = 0;
                for (int i = 0; i < 10; i++) {
                    for (int num : buckets[i]) {
                        arr[idx++] = num;
                    }
                    buckets[i].clear();
                }

                divisor *= 10;
            }
        }

    }
}