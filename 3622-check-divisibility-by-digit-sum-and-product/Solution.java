class Solution {
    public int[] helper(int n){
        int[] arr = new int[2];
        arr[1] = 1;
        while(n > 0){
            int rem = n %10;
            arr[1] *= rem;
            arr[0] += rem;
            n /= 10;
        }
        return arr;
    }
    public boolean checkDivisibility(int n) {
        int[] arr = helper(n);
        return (n % (arr[0] + arr[1]) == 0);
    }
}