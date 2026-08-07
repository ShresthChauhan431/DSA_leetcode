class Solution {
    void helper(int i, int end, int len, long sum, int[] nums, Map<Integer, Set<Long>> map){
        if(i == end){
            if(!map.containsKey(len)){
                map.put(len, new HashSet<>());
            }
            map.get(len).add(sum);
            return;
        }
        helper(i + 1, end, len + 1, sum + nums[i], nums, map);
        helper(i + 1, end, len, sum, nums, map);
    }
    public int minimumDifference(int[] nums) {
        Map<Integer, Set<Long>> map1 = new HashMap<>();
        Map<Integer, Set<Long>> map2 = new HashMap<>();

        int n = nums.length;
        int mid = n/2;
        long sum = 0;
        for(int i: nums) sum += i;
        helper(0, mid, 0, 0L, nums, map1);
        helper(mid, n, 0, 0L, nums, map2);

        long ans = (long)1e9;

        for(Map.Entry<Integer, Set<Long>> entry: map1.entrySet()) {
            int needlen = mid - entry.getKey();
            List<Long> arr = new ArrayList<>(entry.getValue());
            for(long a: arr) {
                long b = (sum - 2 * a)/2;
                List<Long> list = new ArrayList<>(map2.get(needlen));
                int x = lowerBound(b, list);
                if(x < list.size()) {
                    long sum1 = a + list.get(x);
                    long sum2 = sum - sum1;
                    ans = Math.min(ans, Math.abs(sum1 - sum2));
                }
                if(x > 0){
                    long sum1 = a + list.get(x - 1);
                    long sum2 = sum - sum1;
                    ans = Math.min(ans, Math.abs(sum1 - sum2));
                }
            }
        }
        return (int)ans;
    }
    public int lowerBound(long tar,  List<Long> list){
        int i = 0;
        int j = list.size(); 
        while(i < j){
            int mid = i + (j - i)/2;
            if(list.get(mid) <= tar){
                i = mid + 1;
            }else
                j = mid;
        }
        return i;
    }
}