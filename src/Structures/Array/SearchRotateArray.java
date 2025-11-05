package Structures.Array;

public class SearchRotateArray {
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] == nums[high]) {
                high--;
            }
            else if (nums[mid] < nums[high]) {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            else {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }


    public static void main(String[] args){
        SearchRotateArray s = new SearchRotateArray();
        int[] array = new int[] {1,1,1,1,1,1,1,1,1,2,1,1,1,1};
        System.out.println(s.search(array,2));
    }
}
