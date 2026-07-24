class Solution {
    Map<Integer, Integer> map;
    int[][] dp;
    int[] stones;
    public boolean helper(int i, int j){

        if(i == stones.length - 1) return true;
        if(dp[i][j] != -1) return dp[i][j] == 1 ? true: false;

        boolean ans = false;
        if(map.containsKey(stones[i] + j)){
            ans = ans || helper(map.get(stones[i] + j), j);
        }
        if(map.containsKey(stones[i] + j + 1)){
            ans = ans || helper(map.get(stones[i] + j + 1), j + 1);
        }

        if(map.containsKey(stones[i] + j - 1) && (stones[i] + j - 1 )!= stones[i]){
            ans = ans || helper(map.get(stones[i] + j - 1), j - 1);
        }
        
        dp[i][j] = ans?1:0;

        return ans;
    }
    public boolean canCross(int[] stones) {

        this.stones = stones;
        if(stones[1] != 1) return false;

        int n = stones.length;
        dp = new int[n + 1][n + 1];
        for(int[] d: dp)
        Arrays.fill(d, -1);
        map = new HashMap<>();

        for(int i = 0; i < stones.length; i++){
            map.put(stones[i], i);
        }
        return helper(1, 1);
    }
}