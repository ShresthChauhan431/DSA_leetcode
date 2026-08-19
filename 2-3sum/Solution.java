class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length; i++){
            
            if(res.size() > 0 && res.get(res.size() - 1).get(0) == nums[i]) continue;
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    while(left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                    left++;
                } 
                else if(sum < 0){
                    left++;
                } 
                else{
                    right--;
                }
            }
        }
        return res;
    }
}