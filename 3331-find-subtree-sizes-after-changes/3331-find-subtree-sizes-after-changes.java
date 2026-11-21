class Solution {
    List<Integer>[] tree;
    int[] ans;
    int[] newParent;
    int[] last;
    String s;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        this.s = s;
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++)
            tree[i] = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        newParent = new int[n];
        newParent[0] = -1;

        last = new int[26];
        Arrays.fill(last, -1);

        build(0);

        List<Integer>[] newTree = new ArrayList[n];
        for (int i = 0; i < n; i++)
            newTree[i] = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            newTree[newParent[i]].add(i);
        }

        ans = new int[n];
        dfs(0, newTree);

        return ans;
    }

    private void build(int u) {
        int c = s.charAt(u) - 'a';
        int prev = last[c];

        if (u != 0) {
            newParent[u] = (prev == -1) ? newParent[u] : prev;
            if (prev == -1)
                newParent[u] = newParent[u];
        }

        last[c] = u;

        for (int v : tree[u]) {
            if (last[s.charAt(v) - 'a'] == -1)
                newParent[v] = u;
            build(v);
        }

        last[c] = prev;
    }

    private int dfs(int u, List<Integer>[] tree) {
        int sz = 1;
        for (int v : tree[u]) {
            sz += dfs(v, tree);
        }
        ans[u] = sz;
        return sz;
    }
}
