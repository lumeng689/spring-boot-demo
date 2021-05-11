package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/08
 **/
public class Solution912 {

    /**
     * 快速排序
     *
     * @param nums
     * @return
     */
    public static int[] sortArray1(int[] nums) {
        return nums;
    }

    /**
     * 堆排序
     *
     * @param nums
     * @return
     */
    public static int[] sortArray2(int[] nums) {
        heapSort(nums);
        return nums;
    }

    private static void heapSort(int[] nums) {
        int len = nums.length - 1;
        buildMaxHeap(nums, len);

        for (int i = len; i >= 1; i--) {
            swap(nums, i, 0);
            len -= 1;
            maxHeapify(nums, 0, len);
        }
    }

    private static void buildMaxHeap(int[] nums, int len) {
        for (int i = len / 2; i >= 0; i--) {
            maxHeapify(nums, i, len);
        }
    }

    private static void maxHeapify(int[] nums, int i, int len) {
        for (; (i << 1) + 1 <= len; ) {
            int lson = (i << 1) + 1;
            int rson = (i << 1) + 2;

            int large;
            if (lson <= len && nums[lson] > nums[i]) {
                large = lson;
            } else {
                large = i;
            }

            if (rson <= len && nums[rson] > nums[large]) {
                large = rson;
            }

            if (large != i) {
                swap(nums, i, large);
                i = large;
            } else {
                break;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    static int[] tmp;

    /**
     * 堆排序
     *
     * @param nums
     * @return
     */
    public static int[] sortArray3(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = (l + r) >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);

        int i = l, j = mid + 1;
        int cnt = 0;

        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[cnt++] = nums[i++];
            } else {
                tmp[cnt++] = nums[j++];
            }
        }

        while (i <= mid) {
            tmp[cnt++] = nums[i++];
        }

        while (j <= r) {
            tmp[cnt++] = nums[j++];
        }

        for (int k = 0; k < r - l + 1; ++k) {
            nums[k + l] = tmp[k];
        }
    }


    public static void main(String[] args) {
        Util.printArray(sortArray1(new int[]{5, 2, 3, 1}));
        Util.printArray(sortArray1(new int[]{5, 1, 1, 2, 0, 0}));

        Util.printArray(sortArray2(new int[]{5, 2, 3, 1}));
        Util.printArray(sortArray2(new int[]{5, 1, 1, 2, 0, 0}));

        Util.printArray(sortArray3(new int[]{5, 2, 3, 1}));
        Util.printArray(sortArray3(new int[]{5, 1, 1, 2, 0, 0}));
    }
}
