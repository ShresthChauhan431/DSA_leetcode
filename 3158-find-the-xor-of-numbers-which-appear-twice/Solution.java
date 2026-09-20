class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int xor = 0;
        for(int i: nums){
            if(set.contains(i)){
                xor ^= i;
            }
            set.add(i);
        }
        return xor;
    }
}