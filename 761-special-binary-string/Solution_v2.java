class Solution {
    public String makeLargestSpecial(String s) {
        List<String> strings = new ArrayList<>();
        int balance = 0;
        int start = 0;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '1') balance++;
            else balance--;
        
            if(balance == 0){
                // System.out.println("hello " + s.substring(start + 1, i));
                String inner = makeLargestSpecial(s.substring(start + 1, i));
                strings.add('1' + inner + '0');
                start = i + 1;
            }
        }
        
        Collections.sort(strings, Collections.reverseOrder());
        StringBuilder out = new StringBuilder();
        for(String sub: strings){
            // System.out.println(sub);
            out.append(sub);
        }
        return out.toString();
    }
}