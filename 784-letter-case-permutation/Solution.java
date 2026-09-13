class Solution {
    public List<String> letterCasePermutation(String s) {
        int n = 0;
        List<String> list = new ArrayList<>(); 
        for(char c: s.toCharArray()){
            if(Character.isLetter(c)){
                n++;
            }
        }
        int total = 1 << n;
        for(int bitmask = 0; bitmask < total; bitmask++){
            StringBuilder sb = new StringBuilder();
            int j = 0;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(Character.isLetter(c)){
                    if((bitmask & (1 << j)) == 0)
                        sb.append(Character.toLowerCase(c));
                    else
                        sb.append(Character.toUpperCase(c));
                    
                    j++;
                }else
                    sb.append(c);
            }
            list.add(sb.toString());
        }
        return list;
    }
}