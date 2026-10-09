class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int brac = 0;
        for (char c : s.toCharArray()) {
            if (c == '('){
                brac++;
                if(brac > 1)
                    sb.append(c);

            }
            else if (c == ')') {
                brac--;
                if(brac != 0)
                    sb.append(c);
            }else{
                sb.append(c);
            }

        }
        return sb.toString();
    }
}