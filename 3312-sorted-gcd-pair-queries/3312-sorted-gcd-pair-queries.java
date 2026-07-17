import java.util.Arrays;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        
        int[] count = new int[maxVal + 1];
        for (int num : nums) {
            count[num]++;
        }
        
        long[] gcdCount = new long[maxVal + 1];
        for (int i = maxVal; i >= 1; i--) {
            long totalMultiples = 0;
            for (int j = i; j <= maxVal; j += i) {
                totalMultiples += count[j];
            }
            
            long totalPairs = (totalMultiples * (totalMultiples - 1)) / 2;
            
            for (int j = 2 * i; j <= maxVal; j += i) {
                totalPairs -= gcdCount[j];
            }
            gcdCount[i] = totalPairs;
        }
        
        long[] prefixSums = new long[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            prefixSums[i] = prefixSums[i - 1] + gcdCount[i];
        }
        
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = binarySearch(prefixSums, queries[i]);
        }
        
        return answer;
    }
    
    private int binarySearch(long[] prefixSums, long target) {
        int low = 1, high = prefixSums.length - 1;
        int ans = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (prefixSums[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}