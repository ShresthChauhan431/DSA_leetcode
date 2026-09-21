class Solution {
    private static int[] helper(List<List<int[]>> graph, int src) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int n = graph.size();

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        pq.offer(new int[]{0, src});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            if (x > dist[y]) {
                continue;
            }
            for (int[] curr : graph.get(y)) {
                int next = curr[0];
                int w = curr[1];

                if (x + w < dist[next]) {
                    dist[next] = x + w;
                    pq.offer(new int[]{dist[next], next});
                }
            }
        }

        return dist;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] time : times) {
            int x = time[0];
            int y = time[1];
            int w = time[2];
            graph.get(x).add(new int[]{y, w});
        }
        int[] arr = helper(graph, k);
        int max = 0;
        for(int i = 1; i < n + 1; i++){
            max = Math.max(max, arr[i]);
        }
        return (max == Integer.MAX_VALUE) ? -1 : max;
    }
}