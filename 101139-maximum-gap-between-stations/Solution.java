class Solution {
    public int maximumGap(String skill, String station) {
        int n = skill.length(); 
        int m = station.length();

        int[] left = new int[n];
        int[] right = new int[n];

        int j = 0;
        for(int i = 0; i < n; i++){
            char c = skill.charAt(i);
            while(j < m && station.charAt(j) != c){
                j++;
            }
            left[i] = j++;
        }

        j = m - 1;
        for(int i = n - 1; i >= 0; i--){
            char c = skill.charAt(i);
            while(j >= 0 && station.charAt(j) != c){
                j--;
            }
            right[i] = j--;
        }

        int max  = 0;
        for(int i = 1; i < n; i++){
            int hi = right[i] - left[i - 1];
            max = Math.max(hi, max);
        }
        return max;
    }
}