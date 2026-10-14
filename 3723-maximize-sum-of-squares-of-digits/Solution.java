class Solution {
    public String maxSumOfSquares(int num, int sum) {
        int i = 9;
        StringBuilder sb = new StringBuilder();
        while(sum > 0){
            if(sum - i >= 0){
                sum -= i;
                sb.append(i);
            }else{
                i--;
            }
            if(sb.length() > num) return "";
        }
        while(sb.length() < num){
            sb.append(0);
        }
        return sb.toString();
    }
}