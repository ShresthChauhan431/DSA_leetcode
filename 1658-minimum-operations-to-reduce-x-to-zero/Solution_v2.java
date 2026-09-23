class Solution {
    public int minOperations(int[] nums, int x) {
        int i = 0; 
        int j = nums.length - 1;
        int count = 0;
        while(i <= j){
            int a = nums[i];
            int b = nums[j];
            if(x == 0) break;
            // System.out.println(a + " " + b  + " " + x);
            if(a > x && b > x) return -1;
            if(a <= x && b > x){
                x -= a;
                i++;
            }
            else if(a > x && b <= x){
                x -= b;
                j--;
            }
            else{
                if(a > b){
                    x -= a;
                    i++;
                }else{
                    x-= b;
                    j--;
                }
            }
            count++;
        }
        if(x != 0) return -1;
        return count;
    }
}