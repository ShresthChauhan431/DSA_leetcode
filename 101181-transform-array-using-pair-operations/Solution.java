class Solution {
    public boolean canTransform(int[] source, int[] target) {
        long sums = 0, sumt = 0;
        for(int x : source)
            sums += x;
        for(int x : target)
            sumt += x;
        return sums == sumt;
    }
}