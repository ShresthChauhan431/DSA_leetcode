class Solution {
    class Node{
        int st, end;
        int h;
        Node left, right;
         Node(int st, int end) {
            this.st = st;
            this.end = end;
        }
    }
    Node root;
    private Node buildTree(int st, int end){
        if(st > end){
            return null;
        }

        Node node = new Node(st, end);
        if(st != end){
            int mid = st + (end - st) / 2;
            node.left = buildTree(st, mid);
            node.right = buildTree(mid + 1, end);
        }
        return node;
    }
    private void update(Node node, int l, int r, int h) {
        if(node == null || r < node.st || l > node.end) {
           return;
        }
        if(l <= node.st && r >= node.end) {
            node.h = Math.max(node.h, h);
            return;
        }
        update(node.left, l, r, h);
        update(node.right, l, r, h);
    }
    private void query(Node node, int[] heights, int parentHeight) {
        if(node == null) return;
        int curr = Math.max(parentHeight, node.h);

        if(node.st == node.end) {
            heights[node.st] = curr;
            return;
        }
        query(node.left, heights, curr);
        query(node.right, heights, curr);
    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int[] arr: buildings){
            set.add(arr[0]);
            set.add(arr[1]);
        }
        List<Integer> list = new ArrayList<>(set);

        root = buildTree(0, list.size() - 2);
        for(int[] arr: buildings){
            int left = Collections.binarySearch(list, arr[0]);
            int right = Collections.binarySearch(list, arr[1]) - 1;
            int h = arr[2];
            update(root, left, right, h);
        }
        int[] heights = new int[list.size() - 1];
        query(root, heights, 0);
        List<List<Integer>> res = new ArrayList<>();
        int prev = 0;
        for(int i = 0; i < heights.length; i++){
            if(heights[i] != prev){
                res.add(Arrays.asList(list.get(i), heights[i]));
                prev = heights[i];
            }
        }
        if (prev != 0) {
            res.add(
                Arrays.asList(
                    list.get(list.size() - 1), 0));
        }
        return res;
    }
}