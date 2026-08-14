// class Solution {
//     public List<List<Integer>> getSkyline(int[][] buildings) {
//         List<int[]> list = new ArrayList<>();
//         for(int[] arr: buildings) {
//             int l = arr[0];
//             int r = arr[1];
//             int h = arr[2];
//             list.add(new int[]{l, -h});
//             list.add(new int[]{r, h});
//         }

//         Collections.sort(list, (a, b) -> {
//             if(a[0] != b[0]) {
//                 return a[0] - b[0];
//             }
//             return a[1] - b[1];
//         });
//         List<List<Integer>> res = new ArrayList<>();
//         PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

//         pq.add(0);

//         int prev = 0;
//         for(int[] arr: list) {
//             int x = arr[0];
//             int h = arr[1];
//             if(h < 0) {
//                 pq.add(-h);
//             }else {
//                 pq.remove(h);
//             }

//             int curr = pq.peek();
//             if(curr != prev) {
//                 res.add(Arrays.asList(x, curr));
//                 prev = curr;
//             }
//         }
//         return res;
//     }
// }

import java.util.*;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> list = new ArrayList<>();

        for (int[] arr : buildings) {
            int l = arr[0];
            int r = arr[1];
            int h = arr[2];

            list.add(new int[]{l, -h, r});
            list.add(new int[]{r, h, r});
        }

        Collections.sort(list, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(b[0], a[0]);
            }
            return Integer.compare(b[1], a[1]);
        });

        pq.add(new int[]{0, Integer.MAX_VALUE});

        List<List<Integer>> res = new ArrayList<>();
        int prev = 0;

        for (int[] arr : list) {
            int x = arr[0];
            int h = arr[1];
            int r = arr[2];

            if (h < 0) {
                pq.add(new int[]{-h, r});
            }

            while (pq.peek()[0] != 0 && pq.peek()[1] <= x) {
                pq.poll();
            }
            int curr = pq.peek()[0];

            if (curr != prev) {
                res.add(Arrays.asList(x, curr));
                prev = curr;
            }
        }

        return res;
    }
}