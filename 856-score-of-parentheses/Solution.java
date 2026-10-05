class Solution {
    
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(char c: s.toCharArray()){
            if(c == '('){
                st.push(0);
            }else{
                int top = st.pop();
                int ans = top == 0 ? 1 : 2 * top;
                st.push(st.pop() + ans);
            }
        }
        return st.pop();
    }
}