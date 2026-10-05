class Solution {
    public boolean helper(List<List<Integer>> graph, int curr, boolean[] visited, boolean[] flag, Stack<Integer> stack) {
        visited[curr] = true;
        flag[curr] = true;

        for (int next : graph.get(curr)) {
            if (flag[next]) {
                return true;
            }
            if (!visited[next]) {
                if (helper(graph, next, visited, flag, stack)) {
                    return true;
                }
            }
        }

        flag[curr] = false;
        stack.push(curr);
        return false;
    }
    public int[] findOrder(int n, int[][] pre) {
        List<Integer> list = new ArrayList<>(); 
        int[] arr = new int[n];
        List<List<Integer>> adj = new ArrayList<>(); 
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] i: pre){
            adj.get(i[1]).add(i[0]);
        }
        boolean[] visited = new boolean[n];
        boolean[] flag = new boolean[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (helper(adj, i, visited, flag, st)) {
                    return new int[]{};  
                }
            }
        }
        for(int i = 0; i < n; i++){
            arr[i] = st.pop();
        }
        return arr;
    }
}