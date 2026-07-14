class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        
        String digit = "123456789";
        for(int l=2; l<=9; l++){
            for(int i=0; i<=9-l; i++){
                int num = Integer.parseInt(digit.substring(i, i+l));
                if(num >= low && num <= high){
                    ans.add(num);
                }
            }
        }
        return ans;
    }
}