class Solution {
    public int countGroups(int[] position, int[] speed, int distance) {
        int n = position.length;
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while(i < n) {
            int j = i;
            while(j + 1 < n && position[j + 1] - position[j] <= distance) {
                j++;
            }
            list.add(speed[j]);
            i = j + 1;
        }

        int count = 0;
        int min = Integer.MAX_VALUE;

        for(int k = list.size() - 1; k >= 0; k--) {
            int curr = list.get(k);
            if(curr <= min) {
                count++;
                min = curr;
            }
        }
        return count;
    }
}