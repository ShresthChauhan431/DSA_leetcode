class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] l = s.toCharArray();
            Arrays.sort(l);
            String x = new String(l);
            if(!map.containsKey(x)){
                map.put(x, new ArrayList<>());
            }
            map.get(x).add(s);
        } 
        List<List<String>> list = new ArrayList<>();
        for(String s: map.keySet()){
            list.add(new ArrayList<>(map.get(s)));
        }
        return list;
    }
}