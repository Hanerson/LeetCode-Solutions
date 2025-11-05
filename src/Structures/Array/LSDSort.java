package Structures.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LSDSort {

    public static void lsdRadixSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        List<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < 10; i++) buckets[i] = new ArrayList<>();

        int divisor = 1;
        boolean hasMoreDigit = true;

        while (hasMoreDigit) {
            hasMoreDigit = false;

            // 分配到桶中
            for (int num : arr) {
                int digit = (num / divisor) % 10;  // 当前位的数字
                buckets[digit].add(num);
                if (num / divisor >= 10) hasMoreDigit = true;
            }

            // 收集桶中元素回到数组
            int idx = 0;
            for (int i = 0; i < 10; i++) {
                for (int num : buckets[i]) {
                    arr[idx++] = num;
                }
                buckets[i].clear(); // 清空桶
            }

            divisor *= 10; // 进入下一位
        }
    }

    // 测试
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66, 0};
        System.out.println("排序前: " + Arrays.toString(arr));
        lsdRadixSort(arr);
        System.out.println("排序后: " + Arrays.toString(arr));
    }
}
