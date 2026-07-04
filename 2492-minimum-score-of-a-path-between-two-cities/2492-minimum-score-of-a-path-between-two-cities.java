class Solution {
    int min = Integer.MAX_VALUE;
    private void dfs(List<List<int []>> adj, boolean[] vis, int src){
        vis[src] = true;

        for(int[] a:adj.get(src)){
            int node = a[0];
            int dist = a[1];
            min = Math.min(min, dist);
            if(!vis[node]) dfs(adj, vis, node);
        }
    }
    
    public int minScore(int n, int[][] roads) {
        List<List<int []>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int []a:roads){
            int u = a[0];
            int v = a[1];
            adj.get(u).add(new int[]{v, a[2]});
            adj.get(v).add(new int[]{u, a[2]});
        }

        // Queue<int[]> pq = new LinkedList<>();
        // pq.offer(new int[]{1, 0});
        // vis[1] = true;
        // while(!pq.isEmpty()){
        //     int []a = pq.poll();
        //     int node = a[0];
        //     int dist = a[1];

        //     for(int[] nbr:adj.get(node)){
        //         int cNode = nbr[0];
        //         int cost = nbr[1];
        //         min = Math.min(min, cost);
        //         if(!vis[cNode]){
        //             pq.offer(new int[]{cNode, cost}); 
        //             vis[cNode] = true;
        //         }
        //     }
        // }
        boolean[] vis = new boolean[n+1];
        dfs(adj, vis, 1);
        return min;
    }
}