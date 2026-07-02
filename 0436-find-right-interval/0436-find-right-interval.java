class Solution {
    public int[] findRightInterval(int[][] inte) {
        int n = inte.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i=0; i<n; i++){
            map.put(inte[i][0], i);
        }
        
        int []ans = new int[n];
        for(int i=0; i<n; i++){
            int start = inte[i][0], end = inte[i][1];
            ans[i] = -1;
             if(map.ceilingKey(end) != null){
                int nextS = map.ceilingKey(end);
                ans[i] = map.get(nextS);
             }

        }
        return ans;
    }
}