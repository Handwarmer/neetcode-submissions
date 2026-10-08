class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[speed.length][];
        for (int i = 0; i < speed.length; i ++) {
            cars[i] = new int[]{position[i], speed[i], i};
        }
        Arrays.sort(cars, (a, b) -> {
            return a[0] - b[0];
        });
        int ans = cars.length;
        double nTime = -1;
        for (int i = cars.length - 1; i>= 0; i --) {
            double cTime = (double)(target-cars[i][0]) / cars[i][1];
            if (cTime <= nTime) {
                ans --;
                nTime = nTime;
            } else {
                nTime = cTime;
            }
        }
        return ans;
    }
}
