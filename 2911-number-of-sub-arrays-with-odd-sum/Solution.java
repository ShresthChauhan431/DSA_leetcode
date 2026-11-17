class Solution {
    private static final int mod = 1_000_000_007;
    public int numOfSubarrays(int[] arr) {
        int sum =0;
        int odd = 0;
        int even =0;
        int res = 0;
        for(int i:arr){
            sum+=i;
            if(sum%2==0){
                res = (res+odd)%mod;
                even++;
            }else{
                odd++;
                res =(res+1+even)%mod;
            }
        } 
        return res%mod;
    }
}