class Solution {
    public int orangesRotting(int[][] grid) {
        int num = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                }
                if(grid[i][j] == 1){
                    num++;
                }
            }
        }
        int count = 0;
        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while(!q.isEmpty() && num > 0){
            int s = q.size();
            for(int i = 0; i < s; i++){
                int[] arr = q.poll();
                for(int j = 0; j < dir.length; j++){
                    int nr = dir[j][0] + arr[0];
                    int nc = dir[j][1] + arr[1];
                    if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        q.offer(new int[]{nr, nc});
                        num--;
                    }
                }
            }
            count++;
        }
        return (num == 0) ? count : -1;
    }
}