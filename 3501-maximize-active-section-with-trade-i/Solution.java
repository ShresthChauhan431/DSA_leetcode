class Solution {
    class pair{
        char ch;
        int len;
        pair(char ch, int len){
            this.ch = ch;
            this.len = len;
        }
    }
    public int maxActiveSectionsAfterTrade(String s) {
        List<pair> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        int ones = 0;
        while(j < s.length()){
            while(j < s.length() && s.charAt(j) == '0'){
                j++;
            }
            if(i < j){
                list.add(new pair('0', j - i));
                i = j;
            }
            while(j < s.length() && s.charAt(j) == '1'){
                j++;
                ones++;
            }
            if(i < j){
                list.add(new pair('1', j - i));
                i = j;
            }
        }

        int best = 0;
        for( i = 1; i < list.size() - 1; i++){
            int gain = 0;
            if(list.get(i - 1).ch == '0' && list.get(i + 1).ch == '0' && list.get(i).ch == '1'){
                gain = list.get(i - 1).len + list.get(i + 1).len;
            }
            best = Math.max(gain, best);
        }
        return best + ones;
    }
}