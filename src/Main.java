import java.io.*;
import java.util.*;

public class Main {
    private static int _partition (int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left - 1,  j = right + 1;
        while(true){
            do{ i ++; } while (nums[i] < pivot);
            do{ j --; } while (nums[j] > pivot);

            if(i >= j) break;
            swap(nums, i, j);
        }
        return j;
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void QuickSort (int[] nums, int left, int right) {
        if(left >= right) return;

        int pivot_index = _partition(nums, left, right);
        QuickSort(nums, left, pivot_index);
        QuickSort(nums, pivot_index + 1, right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        QuickSort(nums, 0 , n - 1);

        for (int i = 0; i < n; i++) {
            bw.write(nums[i] + (i == n - 1 ? "\n" : " "));
        }
        bw.flush();
    }
}