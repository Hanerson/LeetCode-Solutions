package Daily;

import java.util.*;

public class MinDifference_2035 {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int total = 0;

        for (int num : nums) total += num;

        int[] left = Arrays.copyOfRange(nums, 0, n);
        int[] right = Arrays.copyOfRange(nums, n, nums.length);

        List<Integer>[] leftSums = new List[n + 1];
        List<Integer>[] rightSums = new List[n + 1];

        for (int i = 0; i <= n; i++) {
            leftSums[i] = new ArrayList<>();
            rightSums[i] = new ArrayList<>();
        }

        generate(left, 0, 0, 0, leftSums);
        generate(right, 0, 0, 0, rightSums);

        for (int i = 0; i <= n; i++) {
            Collections.sort(rightSums[i]);
        }

        int ans = Integer.MAX_VALUE;

        for (int k = 0; k <= n; k++) {
            List<Integer> leftList = leftSums[k];
            List<Integer> rightList = rightSums[n - k];

            for (int leftSum : leftList) {
                int target = total / 2 - leftSum;

                int idx = Collections.binarySearch(rightList, target);

                if (idx < 0) idx = -idx - 1;

                if (idx < rightList.size()) {
                    int pick = leftSum + rightList.get(idx);
                    ans = Math.min(ans, Math.abs(total - 2 * pick));
                }

                if (idx > 0) {
                    int pick = leftSum + rightList.get(idx - 1);
                    ans = Math.min(ans, Math.abs(total - 2 * pick));
                }
            }
        }

        return ans;
    }

    private void generate(int[] nums, int index, int count, int sum, List<Integer>[] sums) {
        if (index == nums.length) {
            sums[count].add(sum);
            return;
        }

        generate(nums, index + 1, count, sum, sums);
        generate(nums, index + 1, count + 1, sum + nums[index], sums);
    }
}