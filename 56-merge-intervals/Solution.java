class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        ArrayList<int[]> arr = new ArrayList<>();
        int[] curr = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (curr[1] < intervals[i][0]) {
                arr.add(curr.clone());
                curr = intervals[i];
            } else {
                curr[0] = Math.min(curr[0], intervals[i][0]);
                curr[1] = intervals[i][1];
            }
        }
        arr.add(curr.clone());
        int[][] ans = new int[arr.size()][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }
}