class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0;
        int n = nums.size();
        
        for (int i = 0; i < n; i++) {
            HashSet<Integer> seen = new HashSet<>();
            for (int j = i; j < n; j++) {
                seen.add(nums.get(j));
                ans += seen.size() * seen.size();
            }
        }
        
        return ans;
    }
}