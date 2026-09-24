class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int low = 0;
        int high = 1;
        int n = nums.length;
        while(high < n){
            if (nums[high] == nums[high - 1]){
                high++;
                continue;
            }else{
                low++;
                nums[low] = nums[high];
                high++;
            }
        }
        return low+1;
    }
}

