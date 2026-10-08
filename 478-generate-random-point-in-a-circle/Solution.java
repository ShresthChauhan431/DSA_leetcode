class Solution {
    double x;
    double y;
    double r;

    public Solution(double radius, double x_center, double y_center) {
        this.x = x_center;
        this.y = y_center;
        this.r = radius;
    }
    
    public double[] randPoint() {
        Random random = new Random();
        double ran = 0d + random.nextDouble() * (1d);
        double thetha = 0d + random.nextDouble() * (2 * Math.PI);
        double dist = Math.sqrt(ran) * r;
        double nx = (x + dist * Math.cos(thetha));
        double ny = (y + dist * Math.sin(thetha));
        return new double[]{nx, ny};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */