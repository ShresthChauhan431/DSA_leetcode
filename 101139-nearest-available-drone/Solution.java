class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int dist = (int)1e6; 
        int ans = -1;
        for(int i = 0; i < drones.length; i++){
            int hi = Math.abs(drones[i][0] - target[0]) + Math.abs(drones[i][1] - target[1]);
            if(hi < drones[i][2] && hi < dist){
                ans = i;
                dist = hi;
            }
        }
        return ans;
    }
}