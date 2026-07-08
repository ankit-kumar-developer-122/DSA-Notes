class Solution {
    public int arrangeCoins(int n) {
        long val = 8L * n + 1;
        
        // Applying the full quadratic formula: (sqrt(8n + 1) - 1) / 2
        return (int)((mySqrt(val) - 1) / 2); 
    }
    public long mySqrt(long n) {
        if (n == 0) return 0;
        long low = 1; 
        long high = n;
        long ans = 0;
        
        while(low <= high) {
            long mid = low + (high - low) / 2;
            
            if(mid == n / mid) return mid;
            else if(mid > n / mid) high = mid - 1;
            else {
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }
}