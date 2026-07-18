class Solution {
    public String rearrangeString(String s, char x, char y) {
      
        
        String res = ""; //to store the result in the ans
        
        for(char c: s.toCharArray()){
            if( c == y){ //we know res is empty so whatever we will add wil be added in the begining
                res += c;
            }
        }
        
        for(char c: s.toCharArray()){
            if(c != y){//we added all y already in res so no need to add y again 
            
                res += c; //if this is not y than add it in result because either it is x or other charater 
            }
        }
        return res;
    }
}

//total case 3
// case 1: it is y if y then add in the begining 
//case 2: it is x or something else so we know we added all the y in the start so now we can add this character does not matter it is y or x 
//because quesiton ask for every y should be before x