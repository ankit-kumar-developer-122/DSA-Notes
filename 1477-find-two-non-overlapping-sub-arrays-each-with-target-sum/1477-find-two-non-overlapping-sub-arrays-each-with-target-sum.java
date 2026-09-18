class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minLen = new int[n];
        Arrays.fill(minLen, Integer.MAX_VALUE);

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int currentSum = 0;
        int result = Integer.MAX_VALUE;
        int bestSoFar = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            currentSum += arr[i];
            map.put(currentSum, i);

            if (map.containsKey(currentSum - target)) {
                int prevIndex = map.get(currentSum - target);
                int currentLen = i - prevIndex;

                if (prevIndex >= 0 && minLen[prevIndex] != Integer.MAX_VALUE) {
                    result = Math.min(result, currentLen + minLen[prevIndex]);
                }

                bestSoFar = Math.min(bestSoFar, currentLen);
            }

            minLen[i] = bestSoFar;
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}