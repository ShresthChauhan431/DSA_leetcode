class Solution {
    List<Integer> primes;
     private void findPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
    
        if(n >= 0) isPrime[0] = false;
        if(n >= 1) isPrime[1] = false;

        for(int p = 2; p * p <= n; p++){
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p){
                    isPrime[i] = false;
                }
            }
        }
        for(int i = 2; i <= n; i++){
            if(isPrime[i]){
                primes.add(i);
            }
        }
    }

    public List<Integer> maxPrimes(int n, int s) {
        primes = new ArrayList<>();
        findPrimes(n);
        List<Integer> ans = new ArrayList<>();
        long sum = 0L;
        for(int i: primes){
            sum += i;
            if(sum > s) break;
            ans.add(i);
        }
        return ans;
    }
}