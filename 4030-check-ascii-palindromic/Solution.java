class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder sb = new StringBuilder(); 
        for(char c: s.toCharArray()){
            int x = (int)c;
            sb.append(String.format("%8s", Integer.toBinaryString(x)).replace(' ', '0'));
        }
        int i =0;
        int j = sb.length() - 1;
        System.out.print(sb);
        while(i < j){
            if(sb.charAt(i) != sb.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}