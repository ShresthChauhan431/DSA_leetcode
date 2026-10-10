class Solution {
    public int[] maxProductPair(int[] nums, int target) {
        int max = -1000000;
        int[] arr = {-1, -1};
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target && nums[i] != nums[j]){
                    if(nums[i] * nums[j] > max){
                        arr  = new int[]{j, i};
                    }
                }
            }
        }
        return arr;
    }
}