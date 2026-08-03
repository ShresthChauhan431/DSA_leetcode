class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0; 
        Map<Character, Integer> map = new HashMap<>();
        // Set<Character> set = new HashSet<>();
        int max = 0;

        while(j < s.length()){
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
            // set.add(c);
            // while(set.contains(c)){
            //     set.remove
            // }
            
            while(map.get(c) > 1){
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                i++;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}