class Solution {
    public int maximumWidth(int[] planks) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: planks){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        int ans = 0;

        Set<Integer> set = new HashSet<>(); 

        for(int i: list){
            for(int j: list){
                set.add(i + j); 
            }
        }
        for(int i: set){
            int w = map.getOrDefault(i, 0);
            int pair = 0;
            for(int x: list){
                int y = i - x; 

                if(!map.containsKey(y))
                    continue;
                if(x < y){
                    pair += Math.min(map.get(x), map.get(y));
                } else if(x == y){
                    pair += map.get(x) / 2;
                }
            }
            ans = Math.max(ans, w + pair);
        }

        return ans;
    }
}