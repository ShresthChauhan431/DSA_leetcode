class Solution {
    public int minRotations(String s) {
        int n = 9; 
        int ans = 0;
        int curr = 0;
        for(char c: s.toCharArray()){
            int num = c - '0';
            if(num < curr){
                ans += Math.min(Math.abs(num - curr), Math.abs(curr - (num + n + 1)));
            }else if(curr < num){
                ans += Math.min(Math.abs(num - curr), Math.abs(num - (curr + n + 1)));
            }
            curr = num;
        }
        return ans;
    }
}