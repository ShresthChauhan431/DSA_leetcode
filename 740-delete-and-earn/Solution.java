class Solution {

    private List<Integer> list;
    private Map<Integer, Integer> map;
    private int[] dp;

    private int helper(int i){
        if (i == list.size())
            return 0;
        
        if (dp[i] != -1) return dp[i];

        int val = list.get(i);
        int take = val * map.get(val);

        if (i < list.size() - 1 && list.get(i + 1) == list.get(i) + 1)
            take += helper(i + 2);
        
        else 
            take += helper(i + 1);
        
        int notTake = helper(i + 1);

        return dp[i] = Math.max(take, notTake);
    }
    public int deleteAndEarn(int[] nums) {

        map = new HashMap<>();
        list = new ArrayList<>();

        for(int i: nums){
            if(!map.containsKey(i))
                list.add(i);
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        dp = new int[list.size()];
        Arrays.fill(dp, -1);
        list.sort(null);
        return helper(0);
    }
}