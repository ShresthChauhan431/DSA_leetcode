class Solution {
    public int countSpecialIntegers(int[] nums) {
        int[] arr = new int[101];
        for(int i: nums){
            arr[i]++;
        }
        int count = 0;
        for(int i = 0; i < 101; i++){
            if(arr[i] == 3){
                List<Integer> list = new ArrayList<>(); 
                for(int j = 0; j < nums.length; j++){
                    if(i == nums[j])
                        list.add(j);   
                }
                if(list.get(1) - list.get(0) == list.get(2) - list.get(1)){
                    count++;
                }
            }
        }
        return count;
    }
}