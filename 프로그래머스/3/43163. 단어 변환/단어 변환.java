import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {

        boolean targetExists = false;
        for (String word : words) {
            if (word.equals(target)) {
                targetExists = true;
                break;
            }
        }
        if (!targetExists) return 0;

        // BFS
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, Integer> distance = new HashMap<>();

        queue.offer(begin);
        visited.add(begin);
        distance.put(begin, 0);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(target)) {
                return distance.get(current);
            }

            for (String word : words) {
                if (!visited.contains(word) && isOneLetterDifference(current, word)) {
                    queue.offer(word);
                    visited.add(word);
                    distance.put(word, distance.get(current) + 1);
                }
            }
        }

        return 0;
    }

    private boolean isOneLetterDifference(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
                if (diff > 1) return false;
            }
        }
        return diff == 1;
    }
}