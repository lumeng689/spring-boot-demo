package org.luapp.tpl.utils;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: 86150
 * @create: 2021/05/31
 **/
public class Interview0306 {
    private static class AnimalShelf {

        LinkedList<Integer> dog = new LinkedList<>();
        LinkedList<Integer> cat = new LinkedList<>();

        public AnimalShelf() {

        }

        public void enqueue(int[] animal) {
            if (animal[1] == 0) {
                cat.add(animal[0]);
            }
            if (animal[1] == 1) {
                dog.add(animal[0]);
            }
        }

        public int[] dequeueAny() {
            if (dog.isEmpty() && cat.isEmpty()) {
                return new int[]{-1, -1};
            }
            if (dog.isEmpty()) {
                return new int[]{cat.pollFirst(), 0};
            }
            if (cat.isEmpty()) {
                return new int[]{dog.pollFirst(), 1};
            }
            if (dog.peekFirst() < cat.peekFirst()) {
                return new int[]{dog.pollFirst(), 1};
            }
            return new int[]{cat.pollFirst(), 0};
        }

        public int[] dequeueDog() {
            if (dog.isEmpty()) {
                return new int[]{-1, -1};
            } else {
                return new int[]{dog.pollFirst(), 1};
            }
        }

        public int[] dequeueCat() {
            if (cat.isEmpty()) {
                return new int[]{-1, -1};
            } else {
                return new int[]{cat.pollFirst(), 0};
            }
        }
    }

    public static void main(String[] args) {
        AnimalShelf obj = new AnimalShelf();
        obj.enqueue(new int[]{});
        int[] param2 = obj.dequeueAny();
        Util.printArray(param2);
        int[] param3 = obj.dequeueDog();
        Util.printArray(param3);
        int[] param4 = obj.dequeueCat();
        Util.printArray(param4);
    }
}
