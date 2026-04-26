import java.util.*;

class Solution {
    public String frequencySort(String s) {
        // step 1: frequency map
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // step 2: list of characters
        List<Character> list = new ArrayList<>(map.keySet());

        // step 3: sort based on frequency, then lexicographically
        Collections.sort(list, (a, b) -> {
            int freqCompare = map.get(a) - map.get(b);
            if (freqCompare != 0) return freqCompare;
            return a - b;
        });

        // step 4: build result
        StringBuilder result = new StringBuilder();
        for (char ch : list) {
            int freq = map.get(ch);
            for (int i = 0; i < freq; i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}