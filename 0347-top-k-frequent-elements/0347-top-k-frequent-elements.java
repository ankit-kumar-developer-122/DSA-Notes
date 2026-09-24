class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Count frequency using Hashmap
        for (int num : nums) {
            freq.put(num,freq.getOrDefault(num, 0) + 1);
        }

        // Converting HashMap to List , so that it can be sorted
        List<Map.Entry<Integer, Integer>> list =
                new ArrayList<>(freq.entrySet());

        // Sort by VALUE in ascending order
        list.sort(Map.Entry.comparingByValue());

        // Reverse -> VALUE descending
        Collections.reverse(list);

        // Get top k KEYS
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }
        return result;
    }
}