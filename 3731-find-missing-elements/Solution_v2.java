class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = 10000;
        int max = 0; 
        Set<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        List<Integer> list = new ArrayList<>();
        for(int i = min + 1; i < max; i++){
            if(!set.contains(i))
                list.add(i);
        }
        // list.sort
        return list;
    }
}