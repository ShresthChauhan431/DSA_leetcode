class Solution {
    class State {
    int i, j;
    long p1, p2;

    State(int i, int j, long p1, long p2) {
        this.i = i;
        this.j = j;
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public boolean equals(Object o) {
        State s = (State) o;
        return i == s.i && j == s.j && p1 == s.p1 && p2 == s.p2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j, p1, p2);
    }
}
    Map<State, Boolean> map;
    private boolean helper(int i, int j, int[] nums, long p1, long p2) {
        if (i > j) 
            return p1 >= p2;
        State cur = new State(i, j, p1, p2);
        if(map.containsKey(cur)) return map.get(cur);
        
        if ((nums.length - (j - i + 1)) % 2 == 0) {
            boolean ans = helper(i + 1, j, nums, p1 + nums[i], p2)
                    || helper(i, j - 1, nums, p1 + nums[j], p2);
            map.put(cur, ans);
            return ans;
        }
        else {
            boolean ans = helper(i + 1, j, nums, p1, p2 + nums[i])
                    && helper(i, j - 1, nums, p1, p2 + nums[j]);
            map.put(cur, ans);
            return ans;
        }
    }

    public boolean predictTheWinner(int[] nums) {
        map = new HashMap<>();
        return helper(0, nums.length - 1, nums, 0L, 0L);
    }
}