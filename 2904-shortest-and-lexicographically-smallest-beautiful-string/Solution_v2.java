class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        List<String> list = new ArrayList<>();
        int count = 0;
        int j = 0;

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
            while(count > k) {
                if(s.charAt(j) == '1') {
                    count--;
                }
                j++;
            }
            if(count == k) {
                while(s.charAt(j) == '0') {
                    j++;
                }
                list.add(s.substring(j, i + 1));
            }
        }

        if(list.isEmpty()) return "";
        

        list.sort((a, b) -> {
            if(a.length() != b.length())
                return Integer.compare(a.length(), b.length());
            return a.compareTo(b);
        });

        return list.get(0);
    }
}