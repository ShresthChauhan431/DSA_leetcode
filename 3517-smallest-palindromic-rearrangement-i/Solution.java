class Solution {
    public String smallestPalindrome(String s) {
        StringBuilder sbl = new StringBuilder();
        StringBuilder sbr = new StringBuilder();
        int[] arr = new int[26];
        for (char c: s.toCharArray()) {
            arr[c - 'a']++;
        }
        char rem = '.';

        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0){
                while (arr[i] > 1) {
                    sbl.append((char)(i + 97));
                    sbr.append((char)(i+ 97));
                    arr[i] -= 2;
                }
                if (arr[i] == 1)
                    rem = (char)(i + 97);
            }
        }
        if (rem != '.')
            sbl.append(rem);
        sbr.reverse();
        sbl.append(sbr.toString());
        return sbl.toString();
    }
}