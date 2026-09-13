class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>(); 
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length; 
        int total = 1 << n; 
        for(int bitmask = 0; bitmask < total; bitmask++){
            List<Integer> subset = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                if((bitmask & (1 << i)) != 0){
                    subset.add(nums[i]);
                }
            }
            subset.sort(null);
            set.add(subset);
        }
        list.addAll(set);
        return list;
    }
}