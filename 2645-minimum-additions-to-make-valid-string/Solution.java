class Solution {
    public int addMinimum(String word) {
        int[] arr = new int[3];
        for(char i : word.toCharArray()){
            arr[i - 'a']++;
        }
        int max = Math.max(arr[0], Math.max(arr[1], arr[2]));
        if(max == 0){
            return 3;
        }
        return (3 * max) - (arr[0] + arr[1] + arr[2]);
    }
}