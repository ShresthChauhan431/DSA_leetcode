class Solution {
    public boolean equalFrequency(String word) {
        int[] arr = new int[26];
        for(char c: word.toCharArray()){
            arr[c - 'a']++;
        }
        int min = 1000;
        int count = 0;
        for(int i: arr){
            if(i == 0) continue;
            min = Math.min(i, min);
        }
        for(int i: arr){
            if(i > min) count++;
        }
        if(count == 0 && min == 1) return true;
        return count == 1;
    }
}