class Solution {
    Map<Integer, Integer> map;
    boolean[][] dp;
    public boolean helper(int i, int j, int[] stones){

        if(i == stones.length - 1) return true;
        if(dp[i][j] != false) return true;

        boolean ans = false;
        if(map.containsKey(stones[i] + j)){
            ans = ans || helper(map.get(stones[i] + j), j, stones);
        }
        else if(map.containsKey(stones[i] + j + 1)){
            ans = ans || helper(map.get(stones[i] + j + 1), j + 1, stones);
        }
        // else{
        //     if(map.containsKey(stones[i] + j - 1) && (stones[i] + j - 1 )!= stones[i]){
        //         ans = ans || helper(map.get(stones[i] + j - 1), j - 1, stones);
        //     }
        // }
        return dp[i][j] = ans;
    }
    public boolean canCross(int[] stones) {

        if(stones[1] != 1) return false;

        int n = stones.length;
        dp = new boolean[n + 1][n + 1];
        map = new HashMap<>();

        for(int i = 0; i < stones.length; i++){
            map.put(stones[i], i);
        }
        return helper(1, 1, stones);
    }
}