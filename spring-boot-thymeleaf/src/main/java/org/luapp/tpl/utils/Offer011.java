package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/16
 **/
public class Offer011 {

    public static int minArray(int[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            return -1;
        }

        if (numbers.length == 1) {
            return numbers[0];
        }

        int low = 0;
        int high = numbers.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (numbers[mid] < numbers[high]) {
                high = mid;
            } else if (numbers[mid] > numbers[high]) {
                low = mid + 1;
            } else {
                high -= 1;
            }
        }

        return numbers[low];
    }

    public static void main(String[] args) {
        System.out.println(minArray(new int[]{3, 4, 5, 1, 2}));
        System.out.println(minArray(new int[]{2, 2, 2, 0, 1}));
    }
}
