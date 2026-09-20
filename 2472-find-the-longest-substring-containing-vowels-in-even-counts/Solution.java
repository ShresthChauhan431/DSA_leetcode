class Solution {
    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public int findTheLongestSubstring(String s) {
        int bitmask = 0; 
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 1);
        map.put('i', 2);
        map.put('o', 3);
        map.put('u', 4);
        

        Map<Integer, Integer> map1 = new HashMap<>(); 
        map1.put(0, -1);
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(isVowel(c)){
                int mask = 1 << (map.get(c));
                bitmask ^= mask;
            }
            if(map1.containsKey(bitmask)){
                max = Math.max(max, i - map1.get(bitmask));
            }else
                map1.put(bitmask, i);
        }
        return max;
    }
}