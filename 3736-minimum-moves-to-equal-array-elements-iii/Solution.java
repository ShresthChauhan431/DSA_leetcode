class Solution {
    public int minMoves(int[] nums) {
        int count =0; 
        int max = 0; 
        for(int i: nums){
            max =Math.max(max,i);
        }
        for(int i: nums){
           count += max-i;
        }
        return count ;
    }
}