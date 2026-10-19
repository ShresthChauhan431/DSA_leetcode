class Graph {
    List<List<int[]>> adj;
    int n;

    public Graph(int n, int[][] edges) {
        adj = new ArrayList<>();
        this.n = n;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] i : edges) {
            adj.get(i[0]).add(new int[] { i[1], i[2] });
        }
    }

    public void addEdge(int[] edge) {
        adj.get(edge[0]).add(new int[] { edge[1], edge[2] });
    }

    public int shortestPath(int start, int end) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        dist[start] = 0;
        pq.add(new int[] { start, 0 });

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            int d = current[1];

            if (u == end)
                return d;
            if (d > dist[u])
                continue;

            if (adj.get(u) != null) {
                for (int[] edge : adj.get(u)) {
                    if (dist[u] + edge[1] < dist[edge[0]]) {
                        dist[edge[0]] = dist[u] + edge[1];
                        pq.add(new int[] { edge[0], dist[edge[0]] });
                    }
                }
            }
        }
        return dist[end] == Integer.MAX_VALUE ? -1 : dist[end];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */