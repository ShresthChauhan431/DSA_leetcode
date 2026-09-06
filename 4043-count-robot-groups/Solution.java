class Solution {
    public int countGroups(int[] position, int[] speed, int distance) {
        Stack<Integer> st = new Stack<>();
        for(int i: speed){
            while(!st.isEmpty() && st.peek() > i){
                st.pop();
            }
            st.push(i);
        }
        return st.size();
    }
}