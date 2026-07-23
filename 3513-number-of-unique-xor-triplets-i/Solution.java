class Solution {
    public int uniqueXorTriplets(int[] nums) {
        if(nums.length >= 3){
            return (int)Math.pow(2, nums.length - 1);
        }
        return nums.length;
    }
}