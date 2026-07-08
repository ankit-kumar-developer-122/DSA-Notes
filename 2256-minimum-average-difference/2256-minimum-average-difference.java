class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long[] pref = new long[n];
        pref[0] = nums[0];

        for(int i= 1; i< n; i++){
            pref[i]= pref[i-1] + nums[i];
        }
        int id = -1;
        long min = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            int f_arr = i+1;
            int s_arr = n-i-1;
            
            long f_av = pref[i] / f_arr;
            if(s_arr == 0) s_arr=1;

            long s_av = (pref[n-1] - pref[i])/s_arr;

            if(Math.abs(f_av - s_av) < min){
                min = Math.abs(f_av - s_av);
                id = i;
            }
        }
        return id;
    }
}