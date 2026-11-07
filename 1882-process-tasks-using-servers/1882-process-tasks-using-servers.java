import java.util.*;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        int[] ans = new int[m];
        
        PriorityQueue<int[]> freeServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        
        PriorityQueue<int[]> busyServers = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        
        for (int i = 0; i < n; i++) {
            freeServers.offer(new int[] {servers[i], i});
        }
        
        long currentTime = 0;
        for (int j = 0; j < m; j++) {
            currentTime = Math.max(currentTime, j);
            
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= currentTime) {
                int[] freed = busyServers.poll();
                freeServers.offer(new int[] {servers[freed[1]], freed[1]});
            }
            
            if (freeServers.isEmpty()) {
                currentTime = busyServers.peek()[0];
                while (!busyServers.isEmpty() && busyServers.peek()[0] <= currentTime) {
                    int[] freed = busyServers.poll();
                    freeServers.offer(new int[] {servers[freed[1]], freed[1]});
                }
            }
            
            int[] assigned = freeServers.poll();
            int serverIdx = assigned[1];
            
            ans[j] = serverIdx;
            busyServers.offer(new int[] {(int) currentTime + tasks[j], serverIdx});
        }
        
        return ans;
    }
}