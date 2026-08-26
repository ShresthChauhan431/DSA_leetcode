class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String res = "";
        int count = 0;
        int j = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                count++;
            }
            while(count > k) {
                if (s.charAt(j) == '1') 
                    count--;
                j++;
            }
            if(count == k) {
                while(s.charAt(j) == '0') {
                    j++;
                }
                String curr = s.substring(j, i + 1);
                if(res.isEmpty() || curr.length() < res.length() || 
                   (curr.length() == res.length() && curr.compareTo(res) < 0)) {
                    res = curr;
                }
            }
        }

        return res;
    }
}