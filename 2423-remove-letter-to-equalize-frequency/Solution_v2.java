class Solution {
    private boolean check(int[] arr){
        int min = 1000;
        int count = 0;
        for(int i: arr){
            if(i == 0) continue;
            min = Math.min(i, min);
        }
        for(int i: arr){
            if(i > min) count++;
        }
        return count == 0;
    }
    public boolean equalFrequency(String word) {
        int[] arr = new int[26];
        for(char c: word.toCharArray()){
            arr[c - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(arr[i] == 0) continue;
            arr[i]--;
            if(check(arr)){
                return true;
            }
            arr[i]++;
        }
        // int min = 1000;
        // int count = 0;
        // int max = 0;
        // int countm = 0;
        // for(int i: arr){
        //     if(i == 0) continue;
        //     min = Math.min(i, min);
        //     max = Math.max(i, max);
        // }
        // for(int i: arr){
        //     if(i > min) count++;
        //     if(i < max) countm++;
        // }
        // if(count == 0 && min == 1) return true;
        // return count == 1 || countm == 1;
        return false;
    }
}