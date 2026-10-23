class Solution {
    public int sortPermutation(int[] nums) {
        int x = 0;
        List<Integer> list = new ArrayList<>(); 
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i){
                list.add(nums[i]);
            }
        }
        if(list.size() == 0) return 0;
        
        int k = list.get(0); 
        for(int i = 1; i < list.size(); i++){
            k = k & list.get(i);
        }
        return k;
    }
}