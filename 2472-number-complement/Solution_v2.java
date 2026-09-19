class Solution {
    public int findComplement(int num) {
        int ans = 0;
        int k = 0;
        while(num > 0){
            int n = (num & 1);
            if(n == 0){
                n = 1;
                n = (n << k);
                ans |= n;
            }
            k++;
            num = num >> 1;
        }
        return ans;
    }
}