class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int totalSum = 0;
        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                int length = end - start + 1;
                if (length % 2 == 1) { // odd len
                    int subarraySum = 0;
                    for (int k = start; k <= end; k++) {// calc subarray sum
                        subarraySum += arr[k];
                    }
                    totalSum += subarraySum;
                }
            }
        }

        return totalSum;
    }
}
