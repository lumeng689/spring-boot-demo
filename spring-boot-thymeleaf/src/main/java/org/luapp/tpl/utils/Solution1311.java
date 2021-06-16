package org.luapp.tpl.utils;


import java.util.*;

/**
 * @author: 86150
 * @create: 2021/06/11
 **/
public class Solution1311 {

    private static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(id);
        visited.add(id);
        int len = 0;
        while (!queue.isEmpty() && len < level) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer idd = queue.poll();
                for (int j = 0; j < friends[idd].length; j++) {
                    if (!visited.contains(friends[idd][j])) {
                        queue.add(friends[idd][j]);
                        visited.add(friends[idd][j]);
                    }
                }
            }
            len++;
        }

        Map<String, Integer> map = new HashMap<>();
        while (!queue.isEmpty()) {
            Integer idd = queue.poll();
            for (int i = 0; i < watchedVideos.get(idd).size(); i++) {
                map.put(watchedVideos.get(idd).get(i), map.getOrDefault(watchedVideos.get(idd).get(i), 0) + 1);
            }
        }


        PriorityQueue<Pair<String, Integer>> priorityQueue = new PriorityQueue<>((t1, t2) -> {
            if (t1.getValue().equals(t2.getValue())) {
                return t1.getKey().compareTo(t2.getKey());
            } else {
                return t1.getValue().compareTo(t2.getValue());
            }
        });
        map.forEach((key, value) -> priorityQueue.add(new Pair<>(key, value)));
        List<String> ans = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            ans.add(priorityQueue.poll().getKey());
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
