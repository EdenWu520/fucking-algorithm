package site.leiwa.leetcode;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/sort-an-array/">数组排序</a>
 */
public class LC912_SortAnArray {
    public static void main(String[] args) {
        int[] nums1 = {5, 2, 3, 1};
        int[] nums2 = {5, 1, 1, 2, 0, 0};
        System.out.println(Arrays.toString(new LC912_SortAnArray().sortArray(nums1)));
        System.out.println(Arrays.toString(new LC912_SortAnArray().sortArray(nums2)));
    }

    public int[] sortArray(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int[] tmp = new int[nums.length];
//        mergeSort(nums, tmp, start, end);
        quickSort(nums, start, end);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int pivot = nums[(end - start) / 2 + start];

        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }
        quickSort(nums, start, right);
        quickSort(nums, left, end);

    }

    private void mergeSort(int[] nums, int[] tmp, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = (end - start) / 2 + start;
        mergeSort(nums, tmp, start, middle);
        mergeSort(nums, tmp, middle + 1, end);
        merge(nums, tmp, start, end, middle);
    }

    private void merge(int[] nums, int[] tmp, int start, int end, int middle) {
        int leftIndex = start;
        int middleLeft = middle + 1;
        int tmpIndex = start;

        while (leftIndex <= middle && middleLeft <= end) {
            if (nums[leftIndex] < nums[middleLeft]) {
                tmp[tmpIndex++] = nums[leftIndex++];
            } else {
                tmp[tmpIndex++] = nums[middleLeft++];
            }
        }
        while (leftIndex <= middle) {
            tmp[tmpIndex++] = nums[leftIndex++];
        }
        while (middleLeft <= end) {
            tmp[tmpIndex++] = nums[middleLeft++];
        }
        for (int i = start; i <= end; i++) {
            nums[i] = tmp[i];
        }
    }
}
