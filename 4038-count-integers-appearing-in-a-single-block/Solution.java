class Solution {
    public int countSpecialIntegers(int[] nums) {
        List<List<Integer>> list = new ArrayList<>(101);
        for (int i = 0; i < 101; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < nums.length; i++) {
            list.get(nums[i]).add(i);
        }
        int count = 0;
        for (List<Integer> l : list) {
            if (l.size() == 0)
                continue;
            boolean flag = true;
            for (int i = 1; i < l.size(); i++) {
                if (l.get(i) != l.get(i - 1) + 1)
                    flag = false;
            }
            if (flag)
                count++;
        }
        return count;
    }
}