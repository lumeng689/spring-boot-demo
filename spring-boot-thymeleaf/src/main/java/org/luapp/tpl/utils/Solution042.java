package org.luapp.tpl.utils;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: 86150
 * @create: 2021/05/24
 **/
public class Solution042 {

    public static int trap1(int[] height) {

        int n = height.length;

        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return ans;
    }

    public static int trap2(int[] height) {
        int ans = 0;

        Deque<Integer> stack = new LinkedList<>();
        int n = height.length;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }

                int left = stack.peek();
                int curWidth = i - left - 1;
                int curHeight = Math.min(height[left], height[i]) - height[top];

                ans += curWidth * curHeight;
            }

            stack.push(i);
        }

        return ans;
    }

    public static int trap3(int[] height) {
        int ans = 0;

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;

        while (left < right) {

            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(trap1(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap1(new int[]{4, 2, 0, 3, 2, 5}));

        System.out.println(trap2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap2(new int[]{4, 2, 0, 3, 2, 5}));

        System.out.println(trap3(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap3(new int[]{4, 2, 0, 3, 2, 5}));
    }
}
