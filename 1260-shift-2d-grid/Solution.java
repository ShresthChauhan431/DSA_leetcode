class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int[] arr = new int[grid.length * grid[0].length];
        int l = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                arr[l++] = grid[i][j];
            }
        }
        rotate(arr, k);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < grid.length; i++){
            list.add(new ArrayList<>());
        }
        l = 0;
        int j = 0;
        while(l < arr.length && j < grid.length){
            for(int i = 0; i < grid[0].length; i++){
                list.get(j).add(arr[l++]);
            }
            j++;
        }
        return list;
    }
    public void rotate(int[] nums, int k) {
       int n =nums.length;
       k = k%n;
       int count =0;
       for(int start=0; count<n; start++){
        int curr = start;
        int current = start;
            int prev = nums[start];

            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current); 
       }
    }
}