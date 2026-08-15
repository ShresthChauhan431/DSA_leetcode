class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int prev = 0;
        int next = 0;
        int count = 0;
        for(int i : requests){
            count += Math.abs(i - prev);
            prev = i;
        }
        return count;
    }
}