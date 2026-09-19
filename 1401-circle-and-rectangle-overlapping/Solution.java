class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        if (xCenter >= x1 && xCenter <= x2 && yCenter >= y1 - radius && yCenter <= y2 + radius) return true;
        
        if (yCenter >= y1 && yCenter <= y2 && xCenter >= x1 - radius && xCenter <= x2 + radius) return true;

        int[][] arr = {{x1, y1}, {x1, y2}, {x2, y1}, {x2, y2}};
        for(int[] i : arr) {
            int dx = i[0] - xCenter;
            int dy = i[1] - yCenter;
            if(dx * dx + dy * dy <= radius * radius) return true;
        }

        return false;
    }
}