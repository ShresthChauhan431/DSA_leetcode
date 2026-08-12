class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        PriorityQueue<Integer> pq1 = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        int l = 0;
        if (k % 2 == 0) {
            for (int i = 0; i < k; i++) {
                pq2.offer(nums[i]);
                if (!pq1.isEmpty() && pq1.peek() > pq2.peek()) {
                    int x = pq1.poll();
                    int y = pq2.poll();
                    pq1.offer(y);
                    pq2.offer(x);
                }
                if (pq1.size() < pq2.size()) {
                    int x = pq2.poll();
                    pq1.offer(x);
                }
            }

            res[l++] = (double) (pq1.peek() + pq2.peek()) / 2;
            int j = k;
            int i = 0;
            while (j < nums.length) {
                int x = nums[i];
                if (pq1.peek() >= x) {
                    pq1.remove(x);
                    pq1.offer(nums[j]);
                } else {
                    pq2.remove(x);
                    pq2.offer(nums[j]);
                }
                if (!pq1.isEmpty() && !pq2.isEmpty() && pq1.peek() > pq2.peek()) {
                    int a = pq1.poll();
                    int b = pq2.poll();
                    pq1.offer(b);
                    pq2.offer(a);
                }
                res[l++] = ((double)pq1.peek() + pq2.peek()) / 2;
                j++;
                i++;
            }
        } else {
            for (int i = 0; i < k; i++) {
                pq2.offer(nums[i]);
                if (!pq1.isEmpty() && pq1.peek() > pq2.peek()) {
                    int x = pq1.poll();
                    int y = pq2.poll();
                    pq1.offer(y);
                    pq2.offer(x);
                }
                if (pq1.size() < pq2.size()) {
                    int x = pq2.poll();
                    pq1.offer(x);
                }
            }

            res[l++] = (double) pq1.peek();
            int j = k;
            int i = 0;
            while (j < nums.length) {
                int x = nums[i];
                if (pq1.peek() >= x) {
                    pq1.remove(x);
                    pq1.offer(nums[j]);
                } else {
                    pq2.remove(x);
                    pq2.offer(nums[j]);
                }
                if (!pq1.isEmpty() && !pq2.isEmpty() && pq1.peek() > pq2.peek()) {
                    int a = pq1.poll();
                    int b = pq2.poll();
                    pq1.offer(b);
                    pq2.offer(a);
                }
                if (pq1.size() < pq2.size()) {
                    int t = pq2.poll();
                    pq1.offer(t);
                }
                res[l++] = (double) (pq1.peek());
                j++;
                i++;
            }
        }
        return res;
    }
}