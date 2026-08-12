class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        PriorityQueue<Integer> pq1 = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        
        Map<Integer, Integer> map = new HashMap<>();

        int l = 0;

        if(k % 2 == 0) {
            for(int i = 0; i < k; i++) {
                pq2.offer(nums[i]);

                if(!pq1.isEmpty() && pq1.peek() > pq2.peek()) {
                    int x = pq1.poll();
                    int y = pq2.poll();
                    pq1.offer(y);
                    pq2.offer(x);
                }

                if(pq1.size() < pq2.size()) {
                    int x = pq2.poll();
                    pq1.offer(x);
                }
            }

            res[l++] = ((double) pq1.peek() + pq2.peek()) / 2;

            int j = k;
            int i = 0;

            int size1 = pq1.size();
            int size2 = pq2.size();

            while(j < nums.length) {
                int x = nums[i];

                map.put(x, map.getOrDefault(x, 0) + 1);

                if(x <= pq1.peek()) {
                    size1--;
                }else {
                    size2--;
                }

                if(nums[j] <= pq1.peek()) {
                    pq1.offer(nums[j]);
                    size1++;
                }else {
                    pq2.offer(nums[j]);
                    size2++;
                }

                while(!pq1.isEmpty() && map.containsKey(pq1.peek())) {
                    int t = pq1.poll();

                    if(map.get(t) == 1) {
                        map.remove(t);
                    }else {
                        map.put(t, map.get(t) - 1);
                    }
                }

                while(!pq2.isEmpty() && map.containsKey(pq2.peek())) {
                    int t = pq2.poll();
                    if(map.get(t) == 1) {
                        map.remove(t);
                    }else {
                        map.put(t, map.get(t) - 1);
                    }
                }
                if(size1 > size2 + 1) {
                    int t = pq1.poll();
                    pq2.offer(t);
                    size1--;
                    size2++;
                }else if (size1 < size2) {
                    int t = pq2.poll();
                    pq1.offer(t);
                    size1++;
                    size2--;
                }
                res[l++] = ((double) pq1.peek() + pq2.peek()) / 2;
                j++;
                i++;
            }

        }else {
            for(int i = 0; i < k; i++) {
                pq2.offer(nums[i]);
                if(!pq1.isEmpty() && pq1.peek() > pq2.peek()) {
                    int x = pq1.poll();
                    int y = pq2.poll();
                    pq1.offer(y);
                    pq2.offer(x);
                }
                if(pq1.size() < pq2.size()) {
                    int x = pq2.poll();
                    pq1.offer(x);
                }
            }

            res[l++] = (double) pq1.peek();

            int j = k;
            int i = 0;

            int size1 = pq1.size();
            int size2 = pq2.size();

            while(j < nums.length) {
                int x = nums[i];

                map.put(x, map.getOrDefault(x, 0) + 1);

                if(x <= pq1.peek()) {
                    size1--;
                }else {
                    size2--;
                }

                if(nums[j] <= pq1.peek()) {
                    pq1.offer(nums[j]);
                    size1++;
                }else {
                    pq2.offer(nums[j]);
                    size2++;
                }

                while(!pq1.isEmpty() && map.containsKey(pq1.peek())) {
                    int t = pq1.poll();

                    if (map.get(t) == 1) {
                        map.remove(t);
                    } else {
                        map.put(t, map.get(t) - 1);
                    }
                }
                while(!pq2.isEmpty() && map.containsKey(pq2.peek())) {
                    int t = pq2.poll();
                    if (map.get(t) == 1) {
                        map.remove(t);
                    } else {
                        map.put(t, map.get(t) - 1);
                    }
                }
                if(size1 > size2 + 1) {
                    int t = pq1.poll();
                    pq2.offer(t);
                    size1--;
                    size2++;
                }else if (size1 < size2) {
                    int t = pq2.poll();
                    pq1.offer(t);
                    size1++;
                    size2--;
                }
                res[l++] = (double) pq1.peek();
                j++;
                i++;
            }
        }
        return res;
    }
}