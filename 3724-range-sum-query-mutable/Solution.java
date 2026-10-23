class NumArray {
    int[] bit;
    int n;
    int[] nums;
    public NumArray(int[] nums) {
        this.n = nums.length; 
        this.nums = nums;
        bit = new int[n + 1];
        for(int i = 0; i < n; i++){
            int update = nums[i];
            for(int j = i + 1; j <= n; j += j & (-j)){
                bit[j] += update;
            }
        }

    }
    
    public void update(int ind, int val) {
        int change = val - nums[ind];
        for(int i = ind + 1; i <= n; i+=(i)){
            bit[i] += change;
        }
    }
    public int find(int ind){
        int sum = 0; 
        for(int i = ind + 1; i > 0; i -= i & (-i)){
            sum += bit[i];
        }
        return sum;
    }
    
    public int sumRange(int left, int right) {
        return find(right) - find(left-1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */