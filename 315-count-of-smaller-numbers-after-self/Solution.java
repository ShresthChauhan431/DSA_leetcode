class Solution {
    class SegmentTree {
        int[] tree;
        int n;
        public SegmentTree(int n){
            this.n = n;
            this.tree = new int[4 * n];
        }
        public void update(int node, int st, int end, int rank){
            if(st == end){
                tree[node] += 1;
                return;
            }
            int mid = st + (end - st) / 2;
            if(rank <= mid) {
                update(2 * node, st, mid, rank);
            }else {
                update(2 * node + 1, mid + 1, end, rank);
            }
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }

        public int query(int node, int st, int end, int l, int h){
            if(l > end || h < st){
                return 0;
            }
            if(l <= st && end <= h){
                return tree[node];
            }
            int mid = st + (end - st) / 2;
            int left = query(2 * node, st, mid, l, h);
            int right = query(2 * node + 1, mid + 1, end, l, h);
            return left + right; 
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int[] arr = nums.clone();
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for(int i: arr){
            if(!map.containsKey(i))
                map.put(i, rank++);
        }

        int m = map.size();
        SegmentTree st = new SegmentTree(m);

        for(int i = nums.length - 1; i >= 0; i--){
            int curr = map.get(nums[i]);
            int idx = 0;
            if(curr > 0) {
                idx = st.query(1, 0, m - 1, 0, curr - 1);
            }
            res.add(idx);
            st.update(1, 0, m - 1, curr);
        }
        Collections.reverse(res);
        return res;
    }
}