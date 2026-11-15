
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            int[] freq = new int[26];

            // Count character frequencies
            for (char ch : word.toCharArray()) {
                freq[ch - 'a']++;
            }

            // Generate unique key
            StringBuilder key = new StringBuilder();

            for (int count : freq) {
                key.append("#").append(count);
            }

            // Create group if key doesn't exist
            map.putIfAbsent(key.toString(), new ArrayList<>());

            // Add word to its group
            map.get(key.toString()).add(word);
        }

        return new ArrayList<>(map.values());
    }
}

