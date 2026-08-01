class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        Map<Integer, Integer>[] arr = new HashMap[n];

        for (int[] i : pick) {
            if (arr[i[0]] == null) {
                arr[i[0]] = new HashMap<>();
            }

            arr[i[0]].put(
                i[1],
                arr[i[0]].getOrDefault(i[1], 0) + 1
            );
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] != null) {
                for (int j : arr[i].keySet()) {
                    if (arr[i].get(j) >= i + 1) {
                        count++;
                        break;
                    }
                }
            }
        }

        return count;
    }
}