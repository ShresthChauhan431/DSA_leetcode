// class Solution {
//     public int mostBooked(int n, int[][] meetings) {
//         PriorityQueue<Integer> pq1 = new PriorityQueue<>();
//         PriorityQueue<long[]> pq2 = new PriorityQueue<>((a,b) -> (b[0] - a[0]));
//         for(int i = 0; i < n; i++){
//             pq1.push(i);
//         }
//         int[] ans = new int[n];
//         for(int i = 0; i < meetings.length; i++){
//             while(!pq2.isEmpty() && pq2.peek()[0] <= meetings[i][0]){
//                 pq1.offer(pq2.pop()[1]);
//             }
//             if(!pq1.isEmpty()){
//                 int curr = pq1.pop();
//                 ans[curr]++;
//                 pq2.offer(new int[]{meetings[i][1], curr});
//             }else{
//                 int dur - meetings[i][1] - meetings[i][0];
//                 long time = pq2.peek() 
//             }
//         }



//     }
// }
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        long[][] rooms = new long[n][2];

        for (int[] meet : meetings) {
            int time = meet[1] - meet[0];
            int min = 0;
            long val = Long.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (rooms[i][0] <= meet[0]) {
                    min = i;  
                    break;
                }

                if (rooms[i][0] < val) {
                    min = i;
                    val = rooms[i][0];
                }
            }

            rooms[min][0] = Math.max(rooms[min][0], meet[0]) + time;
            rooms[min][1]++;
        }

        int ans = 0;
        long maxCount = -1;

        for (int i = 0; i < n; i++) {
            if (rooms[i][1] > maxCount) {
                maxCount = rooms[i][1];
                ans = i;
            }
        }

        return ans;
    }
}