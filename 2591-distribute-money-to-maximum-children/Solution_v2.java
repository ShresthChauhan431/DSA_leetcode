class Solution {
    public int distMoney(int money, int children) {
        if(children > money) return -1;
        int curr = 0;
        int count = 0;
        while(money > 0){
            int hi = money - 8;
            if((hi == 4 || hi < children - curr + 1) && hi != 0){
                break;
            }
            curr++;
            money -= 8;
        }
        return curr;
    }
}