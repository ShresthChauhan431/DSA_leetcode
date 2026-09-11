import java.util.Arrays;

class Solution {
    int count = 0;
    
    public void helper(int i, StringBuilder sb, int[] nums, int mask){
        if(sb.length() == 3){
            if((sb.charAt(sb.length() - 1) - '0') % 2 == 0) count++;
            return;
        }
        
        for(int j = 0; j < nums.length; j++){
            if((mask & (1 << j)) != 0) continue;
            if(j > 0 && nums[j] == nums[j-1] && (mask & (1 << (j - 1))) == 0) continue;
            if(sb.length() == 0 && nums[j] == 0) continue;
            int nmask = mask | (1 << j);
            sb.append(nums[j]);
            helper(i + 1, sb, nums, nmask);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    public int totalNumbers(int[] digits) {
        Arrays.sort(digits); 
        helper(0, new StringBuilder(), digits, 0);
        return count;
    }
}