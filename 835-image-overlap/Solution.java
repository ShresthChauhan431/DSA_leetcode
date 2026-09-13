class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
       List<int[]> list1 = new ArrayList<>();
       List<int[]> list2 = new ArrayList<>();
       
       for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(img1[i][j] == 1)
                list1.add(new int[]{i, j});
            
            if(img2[i][j] == 1)
                list2.add(new int[]{i, j});
        }
       }
       HashMap<String, Integer> map = new HashMap<>();
       for(int i = 0; i < list1.size(); i++){
        for(int j = 0; j < list2.size(); j++){
            int dr = list2.get(j)[0] - list1.get(i)[0];
            int dc = list2.get(j)[1] - list1.get(i)[1];
            String p = dr + "$" + dc;
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
       }

       int ans = 0;
       for(int i: map.values()){
        ans = Math.max(ans, i);
       }
       return ans;
    }
}