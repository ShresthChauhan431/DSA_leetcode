class Solution {
    Set<Integer> set;
    public boolean helper(int i, int n, List<Integer> list){
        if(i == 3) return true;
        for(int j: list){
            int k = n - j;
            if(set.contains(k)){
                return helper(i + 1, k, list);
            }
        }
        return false;
    }
    public boolean threeFibonacciSum(int n) {
        set = new HashSet<>(); 
        List<Integer> list = new ArrayList<>();

        int i = 0;
        int j = 1;
        set.add(i);
        list.add(i);
        set.add(j);
        list.add(j);
        while(true){
            int x = i + j;
            if(x + i + j > n) break;
            i = j;
            j = x;
            set.add(x);
            list.add(x);
        }
        return helper(1, n, list);
    }
}