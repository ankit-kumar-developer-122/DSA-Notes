class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int qLen = queries.length;
        Integer[] queryIndices = new Integer[qLen];
        for (int i = 0; i < qLen; i++) {
            queryIndices[i] = i;
        }
        
        Arrays.sort(queryIndices, Comparator.comparingInt(i -> queries[i]));
        Arrays.sort(logs, Comparator.comparingInt(a -> a[1]));
        
        int[] ans = new int[qLen];
        Map<Integer, Integer> freq = new HashMap<>();
        
        int left = 0, right = 0;
        int logLen = logs.length;
        
        for (int qi : queryIndices) {
            int q = queries[qi];
            int startTime = q - x;
            
            while (right < logLen && logs[right][1] <= q) {
                int server = logs[right][0];
                freq.put(server, freq.getOrDefault(server, 0) + 1);
                right++;
            }
            
            while (left < logLen && logs[left][1] < startTime) {
                int server = logs[left][0];
                freq.put(server, freq.get(server) - 1);
                if (freq.get(server) == 0) {
                    freq.remove(server);
                }
                left++;
            }
            
            ans[qi] = n - freq.size();
        }
        
        return ans;
    }
}