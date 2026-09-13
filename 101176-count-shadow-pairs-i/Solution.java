class Solution {
    public long shadowPairs(int[] nums) {
        int n = nums.length; 
        long count = 0;
        int[] arr = new int[n];
        Arrays.fill(arr, n);
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && nums[st.peek()] > nums[i]){
                arr[st.pop()] = i;
            }
            st.push(i);
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        
        for(int i = 0; i < n; i++){
            int x = arr[i] - i - 1;
            if(x <= 0) continue;
            List<Integer> list = map.get(nums[i]);
            int y = Collections.binarySearch(list, i);
            int z = Collections.binarySearch(list, arr[i]);
            if(z < 0) z = - z - 1;
            int hi = z - (y + 1);
            count += x - hi;
            
        }
        return count;
    }
}