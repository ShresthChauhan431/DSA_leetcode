class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        int count = 0;
        for(List<Integer> list: map.values()){
            if(list.size() < 3)continue;
            int gap = list.get(1) - list.get(0);
            boolean flag = true;
            for(int k = 2; k < list.size(); k++){
                if(list.get(k) - list.get(k - 1) != gap){
                    flag = false;
                    break;
                }
            }
            if(flag) count++;
        }
        return count;
    }
}