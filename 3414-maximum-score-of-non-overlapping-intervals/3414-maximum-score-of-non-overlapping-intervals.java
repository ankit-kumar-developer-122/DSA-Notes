class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }
        Arrays.sort(order, (a, b) -> Integer.compare(intervals.get(a).get(1), intervals.get(b).get(1)));
        
        int[] rights = new int[n];
        for (int i = 0; i < n; i++) {
            rights[i] = intervals.get(order[i]).get(1);
        }

        State[] prev = new State[n + 1];
        for (int i = 0; i <= n; i++) {
            prev[i] = new State(0, new int[0]);
        }

        for (int k = 1; k <= 4; k++) {
            State[] cur = new State[n + 1];
            cur[0] = new State(0, new int[0]);

            for (int p = 1; p <= n; p++) {
                int origIdx = order[p - 1];
                List<Integer> interval = intervals.get(origIdx);
                int l = interval.get(0);
                long w = interval.get(2);

                int j = binarySearch(rights, l);

                State takeState = prev[j];
                long newScore = takeState.score + w;
                int[] newIndices = new int[takeState.indices.length + 1];
                System.arraycopy(takeState.indices, 0, newIndices, 0, takeState.indices.length);
                newIndices[newIndices.length - 1] = origIdx;
                Arrays.sort(newIndices);
                State take = new State(newScore, newIndices);

                State skip = cur[p - 1];

                if (isBetter(take, skip)) {
                    cur[p] = take;
                } else {
                    cur[p] = skip;
                }
            }
            prev = cur;
        }

        return prev[n].indices;
    }

    private int binarySearch(int[] rights, int target) {
        int low = 0, high = rights.length - 1;
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (rights[mid] < target) {
                ans = mid + 1;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean isBetter(State a, State b) {
        if (a.score != b.score) {
            return a.score > b.score;
        }
        int len = Math.min(a.indices.length, b.indices.length);
        for (int i = 0; i < len; i++) {
            if (a.indices[i] != b.indices[i]) {
                return a.indices[i] < b.indices[i];
            }
        }
        return a.indices.length < b.indices.length;
    }

    static class State {
        long score;
        int[] indices;

        State(long score, int[] indices) {
            this.score = score;
            this.indices = indices;
        }
    }
}