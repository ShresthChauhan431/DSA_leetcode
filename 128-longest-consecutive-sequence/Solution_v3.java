class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums)
            set.add(num);
        int max =1;
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i: nums){
            int count = 1;
            int x = i;
            while(set.contains(x - 1)){
                x--;
                if(map.containsKey(x)){
                    count += map.get(x);
                    break;
                }
                count++;
            }
            map.put(i, count);
            max = Math.max(count, max);
        }
        return max;
    }
}