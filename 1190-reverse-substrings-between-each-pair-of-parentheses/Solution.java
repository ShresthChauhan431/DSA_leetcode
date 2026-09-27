class Solution {
    public void reverse(char[] arr, int i, int j){
        
        while(i < j){
            if(arr[i] == '(' || arr[j] == ')'){
                i++;
                j--;
                continue;
            }
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder(); 
        char[] arr = s.toCharArray();
        
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                st.add(i);
            }
            if(s.charAt(i) == ')'){
                reverse(arr, st.pop() + 1, i - 1);
            }
        }
        for(char c: arr){
            if(c == '(' || c == ')') continue;
            sb.append(c);
        }
        return sb.toString();
    }
}