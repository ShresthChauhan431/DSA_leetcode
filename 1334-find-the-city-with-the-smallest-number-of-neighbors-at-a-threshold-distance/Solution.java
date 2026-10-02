class Solution {
    public int findTheCity(int n, int[][] edges, int hi) {
        int[][] arr = new int[n][n];
        for(int[] i: arr){
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        for(int[] i: edges){
            arr[i[0]][i[1]] = i[2];
            arr[i[1]][i[0]] = i[2];
        }
        for(int i =0; i < n; i++){
            arr[i][i] = 0;
        }

        for(int k = 0; k < n; k++){
            for(int j = 0; j < n; j++){
                for(int i = 0; i < n; i++){
                    if(arr[i][k] != Integer.MAX_VALUE && arr[k][j] != Integer.MAX_VALUE)
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
        int prev = Integer.MAX_VALUE;
        int res = 0;
        for(int i =0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(arr[i][j] <= hi){
                    count++;
                }
            }
            if(count <= prev){
                res = i;
                prev = count;
            }
        }
        return res;
    }
}