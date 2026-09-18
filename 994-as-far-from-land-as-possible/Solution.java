class Solution {
    public int maxDistance(int[][] grid) {
        int water = 0; 
        Queue<int[]> q = new LinkedList<>(); 
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    q.offer(new int[]{i, j});
                }
                if(grid[i][j] == 0){
                    water++;
                }
            }
        }
        if(water == 0 || q.isEmpty()){
            return -1;
        }
        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int count = 0;
        while(!q.isEmpty()){
            int s = q.size(); 
            for(int i = 0; i < s; i++){
                int[] arr = q.poll();
                for(int[] d: dir){
                    int ni = arr[0] + d[0];
                    int nj = arr[1] + d[1];
                    if(ni >= 0 && nj >= 0 && ni < grid.length && nj < grid[0].length && grid[ni][nj] == 0){
                        grid[ni][nj] = 1;
                        q.offer(new int[]{ni, nj});
                        water--;
                    }
                }
            }
            count++;
        }

        return (water == 0 )? count - 1: -1;
    }
}