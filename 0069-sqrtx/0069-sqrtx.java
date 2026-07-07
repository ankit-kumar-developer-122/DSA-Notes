class Solution {
    public int mySqrt(int n) {
        if (n==0) return 0;
        int low = 1; int high = n;int ans=0;
        while(low<=high){
            int mid= low + (high-low)/2;
            if(mid == n/mid) return mid;
            else if(mid > n/mid) high = mid -1;
            else{
                ans = mid;
                low = mid+1;
            } 
        }
        return ans;
    }
}