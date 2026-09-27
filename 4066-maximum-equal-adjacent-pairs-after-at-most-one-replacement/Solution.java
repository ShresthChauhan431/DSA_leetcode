class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int j = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while(map.size() > 2){
                map.put(nums[j], map.get(nums[j]) - 1);
                if(map.get(nums[j]) == 0)
                    map.remove(nums[j]);
                j++;
            }
            max = Math.max(max, i - j + 1);
        }
        return max - 1;
    }
}