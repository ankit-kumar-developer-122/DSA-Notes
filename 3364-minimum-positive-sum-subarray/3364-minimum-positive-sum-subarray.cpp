class Solution {
public:
    int minimumSumSubarray(vector<int>& nums, int l, int r) {
        int min_sum = -1;
        int n = nums.size();
        
        for (int len = l; len <= r; ++len) {
            for (int i = 0; i <= n - len; ++i) {
                int current_sum = 0;
                for (int j = i; j < i + len; ++j) {
                    current_sum += nums[j];
                }
                if (current_sum > 0) {
                    if (min_sum == -1 || current_sum < min_sum) {
                        min_sum = current_sum;
                    }
                }
            }
        }
        
        return min_sum;
    }
};