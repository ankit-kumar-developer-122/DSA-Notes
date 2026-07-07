class Solution {
    public int mySqrt(int n) {
        int low = 0; int high = n;int ans=0;
        while(low<=high){
            long mid= (low+high)/2;
            if(mid * mid == (long)n) return (int)mid;
            else if(mid * mid > (long)n) high = (int)mid -1;
            else{
                ans = (int)mid;
                low = (int)mid+1;
            } 
        }
        return ans;
    }
}