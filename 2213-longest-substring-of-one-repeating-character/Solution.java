class Solution {

    class Node {
        char leftChar;
        char rightChar;
        int leftLen;
        int rightLen;
        int maxLen;
        int len;

        Node() {
        }

        Node(char ch) {
            this.leftChar = ch;
            this.rightChar = ch;
            this.leftLen = 1;
            this.rightLen = 1;
            this.maxLen = 1;
            this.len = 1;
        }
    }

    class SegmentTree {

        Node[] tree;
        char[] s;

        SegmentTree(String sb) {
            s = sb.toCharArray();
            tree = new Node[4 * s.length];
            build(1, 0, s.length - 1);
        }

        private void build(int node, int start, int end) {

            if(start == end) {
                tree[node] = new Node(s[start]);
                return;
            }

            int mid = start + (end - start) / 2;

            build(2 * node, start, mid);
            build(2 * node + 1, mid + 1, end);

            tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
        }

        public Node merge(Node left, Node right) {

            Node res = new Node();

            res.len = left.len + right.len;

            res.leftChar = left.leftChar;
            res.rightChar = right.rightChar;

            res.leftLen = left.leftLen;

            if(left.leftLen == left.len && left.rightChar == right.leftChar) 
                res.leftLen = left.len + right.leftLen;
            

            res.rightLen = right.rightLen;

            if(right.rightLen == right.len && left.rightChar == right.leftChar) 
                res.rightLen = right.len + left.rightLen;
            

            res.maxLen = Math.max(left.maxLen, right.maxLen);

            if(left.rightChar == right.leftChar)
                res.maxLen = Math.max(res.maxLen, left.rightLen + right.leftLen);
            
            return res;
        }

        private void update(int node, int start, int end, int index, char ch){

            if(start == end) {
                tree[node] = new Node(ch);
                return;
            }

            int mid = start + (end - start) / 2;
            if(index <= mid) 
                update(2 * node, start, mid, index, ch);
            else 
                update(2 * node + 1, mid + 1, end, index, ch);
            

            tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
        }

        public void update(int idx, char ch) {
            s[idx] = ch;
            update(1, 0, s.length - 1, idx, ch);
        }

        int getLongest() {
            return tree[1].maxLen;
        }
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices){ 

        SegmentTree sg = new SegmentTree(s);

        int n = queryIndices.length;
        int[] res = new int[n];

        for(int i = 0; i < n; i++) {
            sg.update(queryIndices[i], queryCharacters.charAt(i));
            res[i] = sg.getLongest();
        }
        return res;
    }
}