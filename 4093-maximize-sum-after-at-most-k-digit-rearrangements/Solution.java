class Solution {
    private int helper(int x){
        ArrayList<Integer> list = new ArrayList<>();
        while(x > 0){
            list.add(x % 10);
            x /= 10;
        }
        Collections.sort(list);
        Collections.reverse(list);
        int total = 0;
        for (int num : list) {
            total = (total * 10) + num;
        }
        
        return total;
    }
    public long maximizeSum(int[] nums, int k) {
        int[][] arr = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++){
            int x = helper(nums[i]);
            arr[i][0] = nums[i];
            if(x - nums[i] > 0){
                arr[i][1] = x - nums[i];
            }
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(b[1], a[1]));
        int i = 0;
        long sum = 0L;
        while(i < nums.length && k > 0 && arr[i][1] > 0){
            sum += (arr[i][0] + arr[i][1]);
            i++;
            k--;
        }
        while(i < nums.length){
            sum += arr[i++][0];
        }
        return sum;
    }
}