class Solution {
    public int findComplement(int num) {
        int ans = 0;
        while(num > 0){
            int n = (num & 1);
            ans = ans << 1;
            if(n == 0){
                ans |= 1;
            }
            num = num >> 1;
        }
        return ans;
    }
}