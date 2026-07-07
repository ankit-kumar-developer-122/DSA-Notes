class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for(int i =0; i < arr.length;i++){
            int left = i+1;
            int right = arr.length -i;
            int total= left*right;
            int odd=(total + 1)/2;
            sum += odd * arr[i];
        }
        return sum;
    }
}
