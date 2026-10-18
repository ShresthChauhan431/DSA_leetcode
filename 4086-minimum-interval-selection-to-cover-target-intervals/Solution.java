class Solution {
    private List<int[]> helper(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> merged = new ArrayList<>();
        int[] curr = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] <= curr[1]) {
                curr[1] = Math.max(curr[1], arr[i][1]);
            } else {
                merged.add(new int[]{curr[0], curr[1]});
                curr = arr[i];
            }
        }
        merged.add(new int[]{curr[0], curr[1]});
        return merged;
    }
    public int minSelection(int[][] availableIntervals, int[][] targetIntervals) {
        List<int[]> list = helper(targetIntervals);
        if(list.isEmpty()) return 0;

        Arrays.sort(availableIntervals, (a,b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]);
        });

        int count = 0;
        int j = 0;
        int m = availableIntervals.length; 
        for(int[] i: list){
            int l = i[0];
            int r = i[1];
            int curr = l;
            while(curr < r){
                int max = -1;
                while(j < m && availableIntervals[j][0] <= curr){
                    max = Math.max(max, availableIntervals[j][1]);
                    j++;
                }
                if(max <= curr){
                    return -1;
                }
                count++;
                curr = max;
            }
        }
        return count;
    }
}