package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/26
 **/
public class Solution744 {

    public static char nextGreatestLetter(char[] letters, char target) {

        int low = 0;
        int high = letters.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (letters[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return letters[low % letters.length];
    }

    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'g'));
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'k'));
    }
}
