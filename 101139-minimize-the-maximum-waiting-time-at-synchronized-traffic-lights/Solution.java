class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int max = 0;
        for(int i: lights){
            max = Math.max(i, max);
        }

        int maxPenalty = 0; 
        for(int i: arrivalTime){
            int r = i % period;
            int wait;
            if(r < max){
                wait = 0;
            }else {
                wait = period - r;
            }

            if(wait > maxPenalty) {
                maxPenalty = wait;
            }
        }
        return maxPenalty;
    }
}