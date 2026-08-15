class NumArray {
    private class Node {
        int data;
        int stInterval, endInterval;
        Node left, right;

        public Node(int stInterval, int endInterval) {
            this.stInterval = stInterval;
            this.endInterval = endInterval;
        }
    }
    class SegmentTree {
        Node root;

        public SegmentTree(int[] arr) {
            this.root = buildTree(arr, 0, arr.length - 1);
        }

        private Node buildTree(int[] arr, int start, int end) {
            if (end == start) {
                Node leaf = new Node(start, end);
                leaf.data = arr[start];
                return leaf;
            }

            Node node = new Node(start, end);
            int mid = start + (end - start) / 2;
            node.left = this.buildTree(arr, start, mid);
            node.right = this.buildTree(arr, mid + 1, end);
            node.data = node.left.data + node.right.data;
            return node;
        }

        public int qwery(int left, int right) {
            return this.qwery(this.root, left, right);
        }

        private int qwery(Node node, int left, int right) {
            if (node.stInterval >= left && node.endInterval <= right) 
                return node.data;
            
            if (node.endInterval < left || node.stInterval > right) 
                return 0;
            
            return qwery(node.left, left, right)
                    + qwery(node.right, left, right);
        }

        public void update(int ind, int x) {
            this.update(root, ind, x);
        }

        private int update(Node node, int ind, int x) {

            if (ind >= node.stInterval && ind <= node.endInterval) {
                if (node.stInterval == node.endInterval) {
                    node.data = x;
                    return node.data;
                }
                int left = update(node.left, ind, x);
                int right = update(node.right, ind, x);

                node.data = left + right;
                return node.data;
            }

            return node.data;
        }
    }

    SegmentTree sg;

    public NumArray(int[] nums) {
        sg = new SegmentTree(nums);
    }

    public void update(int index, int val) {
        sg.update(index, val);
    }

    public int sumRange(int left, int right) {
        return sg.qwery(left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */