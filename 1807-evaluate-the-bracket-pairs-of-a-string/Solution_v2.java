class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> map = new HashMap<>();
        for(List<String> li: knowledge){
            map.put(li.get(0), li.get(1));
        }
        StringBuilder sb = new StringBuilder();
        int st = 0;
        boolean flag = true;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                st = i+1;
                flag = false;
                continue;
            }
            if(s.charAt(i) == ')'){
                flag = true;
                if(map.containsKey(s.substring(st, i)))
                    sb.append(map.get(s.substring(st, i)));
                else{
                    sb.append("?");
                }
                continue;
            }
            if(flag){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}