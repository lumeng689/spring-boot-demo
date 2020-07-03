package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2020/04/19
 **/
public class KMP {

    public static int[] getNext1(String s) {
        int[] next = new int[s.length()];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < s.length() - 1) {
            if (j == -1 || s.charAt(i) == s.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    public static void kmp2(String txt, String pat) {
        int M = pat.length();
        int N = txt.length();
        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int next[] = getNext2(pat);
        int j = 0; // index for pat[]
        int i = 0; // index for txt[]
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.println("Found pattern "
                        + "at index " + (i - j));
//                return (i-j);
                j = next[j - 1];
            }
            // mismatch after j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0) {
                    j = next[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
//        return -1;
    }

    public static int[] getNext2(String pat) {

        int M = pat.length();
        int next[] = new int[M];
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        next[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                next[i] = len;
                i++;
            } else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = next[len - 1];
                    // Also, note that we do not increment
                    // i here
                } else // if (len == 0)
                {
                    next[i] = len;
                    i++;
                }
            }
        }

        return next;
    }

    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println("");
    }

    public static int kmp(String s, String p) {

        int[] next = getNext1(p);

        int i = 0, j = 0;

        while (i < s.length() && j < p.length()) {
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == p.length()) {
            return i - p.length();
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        printArray(getNext1("ABCABD"));
        printArray(getNext2("ABCABD"));
        printArray(getNext2("ABCDABD"));

        printArray(getNext1("abcac"));
        printArray(getNext2("abcac"));
        printArray(getNext1("ababaaababaa"));

        System.out.println(kmp("a3asdf3abcac33232a;fja93423423", "abcac"));
        kmp2("a3asdf3abcac33232a;fja93423423", "abcac");
    }
}
