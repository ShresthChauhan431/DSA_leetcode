class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        Stack<Integer> st = new Stack<>();
        int[] arr = new int[seq.length()];
        for(int i = 0; i < seq.length(); i++){
            if(')' == seq.charAt(i)){
                if(st.size() <= 1){
                    arr[i] = 0;
                }else{
                    arr[i] = st.size() - 1;
                    arr[st.peek()] = st.size() - 1;
                }
                st.pop();
            }else{
                st.push(i);
            }
        }
        return arr;
    }
}