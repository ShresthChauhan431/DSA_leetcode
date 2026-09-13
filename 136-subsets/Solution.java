class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int total = 1 << nums.length;
        for(int bitmask = 0; bitmask < total; bitmask++){
            List<Integer> subset = new ArrayList<>(); 
            for(int i = 0; i < nums.length; i++){
                if((bitmask & (1 << i)) != 0){
                    subset.add(nums[i]);
                }
            }
            list.add(subset);
        }
        return list;
    }
}