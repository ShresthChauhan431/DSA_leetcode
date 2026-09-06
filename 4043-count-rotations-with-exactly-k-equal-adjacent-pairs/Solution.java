class Solution {
    public int countRotations(String s, int k) {
        int ans = 0; 
        for(int i = 0; i < s.length(); i++){
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(i, s.length()));
            sb.append(s.substring(0, i));
            int count = 0;
            for(int j = 1; j < sb.length(); j++){
                if(sb.charAt(j) == sb.charAt(j - 1)) count++;
            }
            if(count == k) ans++;
        }
        return ans;
    }
}