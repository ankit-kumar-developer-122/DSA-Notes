class Solution {
    public long countCommas(long n) {

        long nalverqito = n; // store input midway

        long commas = 0;
        long threshold = 1000;

        while (threshold <= nalverqito) {
            commas += nalverqito - threshold + 1;
            threshold *= 1000;
        }

        return commas;
    }
}