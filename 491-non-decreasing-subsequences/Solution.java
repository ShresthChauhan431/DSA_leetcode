// class Solution {
//     public List<List<Integer>> findSubsequences(int[] nums) {
//         List<List<Integer>> res = new ArrayList<>();
//         helper(nums, 0, new ArrayList<>(), res);
//         return res;
//     }

//     private void helper(int[] nums, int i, List<Integer> curr, List<List<Integer>> res) {
//         if(curr.size() >= 2) {
//             res.add(new ArrayList<>(curr));
//         }

//         Set<Integer> set = new HashSet<>(); 
//         for(int j = i; j < nums.length; j++){
//             if(set.contains(nums[j])) continue;
//             if(curr.isEmpty() || nums[j] >= curr.getLast()){
//                 set.add(nums[j]);
//                 curr.add(nums[j]);
//                 helper(nums, j + 1, curr, res);
//                 curr.removeLast();
//             }
//         }
//     }
// }

class Solution {
    HashSet<String> set;
    List<List<Integer>> res;

    void helper(int i, int[] arr, List<Integer> current) {
        if (i == arr.length) {
            if (current.size() >= 2) {
                String key = current.toString();
                if (!set.contains(key)) {
                    set.add(key);
                    res.add(new ArrayList<>(current));
                }
            }
            return;
        }

        if (current.isEmpty() || current.get(current.size() - 1) <= arr[i]) {
            current.add(arr[i]);
            helper(i + 1, arr, current);
            current.remove(current.size() - 1);
        }
        helper(i + 1, arr, current);
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new ArrayList<>();
        set = new HashSet<>();
        helper(0, nums, new ArrayList<>());
        return res;
    }
}