class Solution {
    public boolean isPalindrome(int n) {
        // code here
        //n = Math.abs(n);
        int num= n;
        int ld;
        int rv = 0;
        while(num>0){
            ld = num%10;
            num = num / 10;
            rv = (rv * 10) + ld;
        }
        if( rv == n) return true;
        else return false;
    }
}