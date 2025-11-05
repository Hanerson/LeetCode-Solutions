package Algorithm;

public class QuickSort {
    public void quickSort(int[] nums, int left, int right){

        if(left >= right) return;

        int pivot_index = partition_Hoare(nums, left, right);
        quickSort(nums, left, pivot_index);
        quickSort(nums, pivot_index + 1, right);
    }

    private int partition_Hoare(int[] nums, int left, int right){
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

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
