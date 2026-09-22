class Solution {
    class SegmentTree {
        int n;
        int k;
        int[][] total; // total[node][r]: count of subsegments starting at node's range with product % k == r
        int[] prod;    // product modulo k of the entire segment covered by node

        public SegmentTree(int[] nums, int k) {
            this.n = nums.length;
            this.k = k;
            this.total = new int[4 * n][k];
            this.prod = new int[4 * n];
            build(1, 0, n - 1, nums);
        }

        private void merge(int node, int left, int right) {
            prod[node] = (prod[left] * prod[right]) % k;
            for (int r = 0; r < k; r++) {
                total[node][r] = total[left][r];
            }
            for (int r = 0; r < k; r++) {
                int newRem = (prod[left] * r) % k;
                total[node][newRem] += total[right][r];
            }
        }

        private void build(int node, int start, int end, int[] nums) {
            if (start == end) {
                int val = nums[start] % k;
                prod[node] = val;
                total[node][val] = 1;
                return;
            }
            int mid = start + (end - start) / 2;
            build(2 * node, start, mid, nums);
            build(2 * node + 1, mid + 1, end, nums);
            merge(node, 2 * node, 2 * node + 1);
        }

        public void update(int node, int start, int end, int idx, int val) {
            if (start == end) {
                for (int r = 0; r < k; r++) total[node][r] = 0;
                int rem = val % k;
                prod[node] = rem;
                total[node][rem] = 1;
                return;
            }
            int mid = start + (end - start) / 2;
            if (idx <= mid) {
                update(2 * node, start, mid, idx, val);
            } else {
                update(2 * node + 1, mid + 1, end, idx, val);
            }
            merge(node, 2 * node, 2 * node + 1);
        }

        public int[] query(int node, int start, int end, int l, int r) {
            if (l <= start && end <= r) {
                int[] res = new int[k + 1];
                for (int i = 0; i < k; i++) res[i] = total[node][i];
                res[k] = prod[node];
                return res;
            }
            int mid = start + (end - start) / 2;
            if (r <= mid) {
                return query(2 * node, start, mid, l, r);
            }
            if (l > mid) {
                return query(2 * node + 1, mid + 1, end, l, r);
            }

            int[] leftRes = query(2 * node, start, mid, l, r);
            int[] rightRes = query(2 * node + 1, mid + 1, end, l, r);

            int[] res = new int[k + 1];
            res[k] = (leftRes[k] * rightRes[k]) % k;
            for (int i = 0; i < k; i++) res[i] = leftRes[i];
            for (int i = 0; i < k; i++) {
                int newRem = (leftRes[k] * i) % k;
                res[newRem] += rightRes[i];
            }
            return res;
        }
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int[] result = new int[q];

        SegmentTree st = new SegmentTree(nums, k);

        for (int i = 0; i < q; i++) {
            int idx = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            st.update(1, 0, n - 1, idx, val);
            int[] queryRes = st.query(1, 0, n - 1, start, n - 1);
            result[i] = queryRes[x];
        }

        return result;
    }
}