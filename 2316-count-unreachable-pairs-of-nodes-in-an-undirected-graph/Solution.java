class Solution {
    private int helper(int src, List<List<Integer>> adj, boolean[] visit) {
        Stack<Integer> st = new Stack<>();
        st.push(src);
        visit[src] = true;
        int count = 0;
        
        while (!st.isEmpty()) {
            int curr = st.pop();
            count++;
            for (int next : adj.get(curr)) {
                if (!visit[next]) {
                    visit[next] = true;
                    st.push(next);
                }
            }
        }
        return count;
    }

    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        boolean[] visit = new boolean[n];
        long res = 0;
        long vis = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                long curr = helper(i, adj, visit);
                res += vis * curr;
                vis += curr;
            }
        }
        
        return res;
    }
}