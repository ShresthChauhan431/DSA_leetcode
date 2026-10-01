class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');


        for(char c: s.toCharArray()){
            if(c == '[' || c == '{' || c == '('){
                st.push(c);
            }else{
                if(!st.isEmpty() && st.peek() == map.get(c)){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        return st.size() == 0;
    }
}