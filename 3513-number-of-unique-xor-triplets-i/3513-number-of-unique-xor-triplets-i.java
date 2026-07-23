class Solution {
    private boolean powerOrNot(int n){
        int []arr = new int[2];
        int lastDigit = 0;
        while(n != 0){
            lastDigit = n % 2;
            arr[lastDigit]++;
            n /= 2;
        }
        return arr[1] == 1 && lastDigit == 1;
    }
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n == 1 || n == 2) return n;

        boolean flag = false;
        n++;
        while(!flag){
            if(powerOrNot(n)){
                return n;
            }
            n++;
        }
        
        return -1;
    }
}