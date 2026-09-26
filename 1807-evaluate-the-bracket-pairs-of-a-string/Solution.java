class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> map = new HashMap<>();
        for(List<String> li: knowledge){
            map.put(li.get(0), li.get(1));
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder st = new StringBuilder();
        boolean flag = true;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                flag = false;
                continue;
            }
            if(s.charAt(i) == ')'){
                flag = true;
                if(map.containsKey(st.toString()))
                    sb.append(map.get(st.toString()));
                else{
                    sb.append("?");
                }
                st = new StringBuilder();
                continue;
            }
            if(!flag){
                st.append(s.charAt(i));
            }
            if(flag){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}