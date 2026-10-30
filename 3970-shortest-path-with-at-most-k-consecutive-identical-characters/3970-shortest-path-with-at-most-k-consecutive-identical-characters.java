class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
        }
        
        int[][] dist = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        
        dist[0][1] = 0;
        pq.offer(new int[]{0, 0, 1});
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int weight = curr[1];
            int count = curr[2];
            
            if (u == n - 1) {
                return weight;
            }
            
            if (weight > dist[u][count]) {
                continue;
            }
            
            for (int[] neighbor : adj[u]) {
                int v = neighbor[0];
                int w = neighbor[1];
                int nextCount = 1;
                
                if (labels.charAt(u) == labels.charAt(v)) {
                    nextCount = count + 1;
                }
                
                if (nextCount <= k && weight + w < dist[v][nextCount]) {
                    dist[v][nextCount] = weight + w;
                    pq.offer(new int[]{v, dist[v][nextCount], nextCount});
                }
            }
        }
        
        return -1;
    }
}