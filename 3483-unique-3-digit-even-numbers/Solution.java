import java.util.Arrays;

class Solution {
    int count = 0;
    
    public void helper(int i, StringBuilder sb, int[] nums, boolean[] used){
        if(sb.length() == 3){
            if((sb.charAt(sb.length() - 1) - '0') % 2 == 0) count++;
            return;
        }
        
        for(int j = 0; j < nums.length; j++){
            if(used[j]) continue;
            if(j > 0 && nums[j] == nums[j-1] && !used[j-1]) continue;
            if(sb.length() == 0 && nums[j] == 0) continue;
            
            used[j] = true;
            sb.append(nums[j]);
            helper(i + 1, sb, nums, used);
            sb.deleteCharAt(sb.length() - 1);
            used[j] = false;
        }
    }
    
    public int totalNumbers(int[] digits) {
        Arrays.sort(digits); 
        helper(0, new StringBuilder(), digits, new boolean[digits.length]);
        return count;
    }
}