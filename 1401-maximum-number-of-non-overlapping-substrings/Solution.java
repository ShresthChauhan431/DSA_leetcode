class Solution {
    public List<String> maxNumOfSubstrings(String s){
        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        for(int i = 0; i < n; i++){
            int c = s.charAt(i) - 'a';
            if(first[c] == -1){
                first[c] = i;
            }
            last[c] = i;
        }

        List<int[]> list = new ArrayList<>();

        for(int c = 0; c < 26; c++){

            if(first[c] == -1)
                continue;
            
            int start = first[c];
            int end = last[c];

            boolean flag = true;

            for(int i = start; i <= end; i++){
                int x = s.charAt(i) - 'a';
                if(first[x] < start) {
                    flag = false;
                    break;
                }
                end = Math.max(end, last[x]);
            }

            if(flag) {
                list.add(new int[]{start, end});
            }
        }

        list.sort((a, b) -> Integer.compare(a[1], b[1]));
        List<String> ans = new ArrayList<>();

        int prev = -1;

        for(int[] i : list){
            int st = i[0];
            int end = i[1];
            if(st > prev){
                ans.add(s.substring(st, end + 1));
                prev = end;
            }
        }

        return ans;
    }
}