class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int x = 0;
        int count = 0;
        for(int i: nums){
            if(i < target){
                x++;
            }else if( i == target){
                count++;
            }
        }
        List<Integer> list = new ArrayList<>();
        while(count > 0){
            list.add(x++);
            count--;
        }
        return list;
    }
}