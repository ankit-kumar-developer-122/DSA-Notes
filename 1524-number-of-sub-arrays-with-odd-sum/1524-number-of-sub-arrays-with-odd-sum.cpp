class Solution {
public:
    int numOfSubarrays(vector<int>& arr) {
        int count = 0;
        int prefixSum = 0;
        int oddCount = 0;
        int evenCount = 1;
        const int MOD = 1e9 + 7;

        for (int num : arr) {
            prefixSum += num;
            if (prefixSum % 2 != 0) {
                count = (count + evenCount) % MOD;
                oddCount++;
            } else {
                count = (count + oddCount) % MOD;
                evenCount++;
            }
        }

        return count;
    }
};