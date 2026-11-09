class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }
        
        int[] count = new int[k];
        int maxRequests = 0;
        
        for (int i = 0; i < arrival.length; i++) {
            int currTime = arrival[i];
            int endTime = currTime + load[i];
            
            while (!pq.isEmpty() && pq.peek()[0] <= currTime) {
                available.add(pq.poll()[1]);
            }
            
            if (available.isEmpty()) {
                continue;
            }
            
            Integer serverId = available.ceiling(i % k);
            if (serverId == null) {
                serverId = available.first();
            }
            
            available.remove(serverId);
            pq.offer(new int[] { endTime, serverId });
            count[serverId]++;
            maxRequests = Math.max(maxRequests, count[serverId]);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == maxRequests) {
                result.add(i);
            }
        }
        
        return result;
    }
}