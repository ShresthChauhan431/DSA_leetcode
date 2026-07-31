class Solution {
    public int minimumPushes(String word) {
        int[] arr = new int[26];
        for (char c: word.toCharArray()) {
            arr[c - 'a']++;
        }
        Arrays.sort(arr);
        int ans = 0, ind = 0;

        for (int i = 25; i >= 0 && arr[i] > 0; i--) {
            ans += arr[i] * (ind / 8 + 1);
            ind++;
        }
        return ans;
    }
}