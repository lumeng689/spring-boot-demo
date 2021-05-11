package org.luapp.tpl.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: 86150
 * @create: 2021/04/30
 **/
public class Solution239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int right = 0; right < nums.length; right++) {
            while (!queue.isEmpty() && nums[right] >= nums[queue.peekLast()]) {
                queue.removeLast();
            }

            queue.addLast(right);

            int left = right - k + 1;
            if (queue.peekFirst() < left) {
                queue.removeFirst();
            }

            if (right + 1 >= k) {
                res[left] = nums[queue.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution239 solution239 = new Solution239();
        Util.printArray(solution239.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
        Util.printArray(solution239.maxSlidingWindow(new int[]{1}, 1));
        Util.printArray(solution239.maxSlidingWindow(new int[]{4, -2}, 2));
    }
}
