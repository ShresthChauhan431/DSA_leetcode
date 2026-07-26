class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        List<List<Integer>> res = new ArrayList<>(); 

        TreeSet<Integer> time = new TreeSet<>();
        for(int[] i: series1) time.add(i[0]);
        for(int[] i: series2) time.add(i[0]);
        int i = 0; 
        int j = 0;
        for(int t: time){
            while(i < series1.length && series1[i][0] < t){
                i++;
            }
            int a = (i < series1.length) ? series1[i][1] : 0;
            while(j < series2.length && series2[j][0] < t){
                j++;
            }
            int b = (j < series2.length) ? series2[j][1] : 0;
            List<Integer> temp = new ArrayList<>();
            temp.add(t);
            temp.add(a + b);
            res.add(temp);
        }
        return res;
    }
}