class Solution {
    boolean isValid(int root, int n, List<List<Integer>> adj, String colors){
        Queue<int[]> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.offer(new int[]{root, 0});
        vis[root] = true;
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int curr = arr[0];
            int d = arr[1];

            char color = colors.charAt(curr);
            char excolor = getColor(d, colors.charAt(root));

            if(color != excolor) return false;

            for(int next: adj.get(curr)){
                if(!vis[next]){
                    vis[next] = true;
                    q.offer(new int[]{next, d + 1});
                }
            }
        }
        return true;
    }
    char getColor(int d, char color){
        int mod = d % 3;
        if(color == 'R') {
            if (mod == 0) return 'R';
            if (mod == 1) return 'B';
            return 'W';
        }else if(color == 'B'){
            if (mod == 0) return 'B';
            if (mod == 1) return 'W';
            return 'R';
        }else {
            if (mod == 0) return 'W';
            if (mod == 1) return 'R';
            return 'B';
        }
    }
    public int findColoredRoot(int[][] edges, String colors) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = colors.length();
        for(int i  =0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        int[] degree = new int[n];
        for(int[] i: edges){
            int u = i[0];
            int v = i[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }

        for(int d: degree){
            if(d > 3) return -1;
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(degree[i] <= 2){
                list.add(i);
            }
        }

        for(int i: list){
            if(isValid(i, n, adj, colors))
                return i;
        }
        return -1;
    }
}