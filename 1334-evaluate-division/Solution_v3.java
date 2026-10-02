class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> map = new HashMap<>(); 
        int ind = 0;
        for(List<String> st: equations){
            if(!map.containsKey(st.get(0)))
                map.put(st.get(0), ind++);

            if(!map.containsKey(st.get(1)))
                map.put(st.get(1), ind++);
        }
        
        int n = map.size(); 
        double[][] arr = new double[n][n];
        for(int i = 0; i < values.length; i++){
            String s1 = equations.get(i).get(0);
            String s2 = equations.get(i).get(1);
            int u = map.get(s1);
            int v = map.get(s2);
            arr[u][v] = values[i];
            arr[v][u] = 1.0 / values[i];
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][k] != 0 && arr[k][j] != 0) {
                        if (arr[i][j] == 0) {
                            arr[i][j] = arr[i][k] * arr[k][j];
                        }
                    }
                }
            }
        }

        double[] ans = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            String s1 = queries.get(i).get(0);
            String s2 = queries.get(i).get(1);
            if(!map.containsKey(s1) || !map.containsKey(s2)){
                ans[i] = -1.0;
            }else{
                ans[i] = arr[map.get(s1)][map.get(s2)];
                if(ans[i] == 0) ans[i] = -1.0;
            }
        }
        return ans;
    }
}