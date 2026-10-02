class Solution {
    List<String> list;
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '('){
                st.push(c);
            }else{
                if(!st.isEmpty() && st.peek() == '('){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        return st.size() == 0;
    }
    public void helper(int i, int n, StringBuilder sb){
        if(i == n * 2){
            if(isValid(sb.toString())){
                list.add(sb.toString());
            }
            return;
        }
        sb.append('(');
        helper(i + 1, n, sb);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(')');
        helper(i + 1, n, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        helper(0, n, new StringBuilder());
        return list;
    }
}