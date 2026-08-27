class Solution {
    public String lexGreaterPermutation(String s, String target){
        int n = s.length();
        int[] arr = new int[26];
        for(char c : s.toCharArray()){
             arr[c - 'a']++;
        }

        for(int len = n; len >= 0; len--){
            int[] count =  arr.clone();
            boolean flag= true;
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < len; i++) {
                char c = target.charAt(i);
                if(count[c - 'a'] > 0) {
                    count[c - 'a']--;
                    sb.append(c);
                }else {
                    flag = false;
                    break;
                }
            }

            if(!flag || len == n) continue;

            char tar = target.charAt(len);
            int next = -1;
            for(int c = tar - 'a' + 1; c < 26; c++) {
                if (count[c] > 0) {
                    next = c;
                    break;
                }
            }

            if(next != -1) {
                count[next]--;
                sb.append((char) ('a' + next));

                for(int c = 0; c < 26; c++) {
                    while(count[c] > 0) {
                        sb.append((char) ('a' + c));
                        count[c]--;
                    }
                }
                return sb.toString();
            }
        }

        return "";
    }
}