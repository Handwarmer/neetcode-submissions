class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> q = new ArrayList<>();
        for (int i = 0; i < position.length; i ++) {
            q.add(new int[]{position[i], speed[i]});
        }
        Collections.sort(q, (int[] a, int[] b) -> {return a[0] - b[0];});
        int[] pre = q.removeLast();
        double pTime = (double)(target - pre[0])/pre[1];
        int ans = 1;
        while (!q.isEmpty()) {
            int[] cur = q.removeLast();
            double cTime = (double)(target - cur[0])/cur[1];
            if (cTime > pTime) {
                ans ++;
                pTime = cTime;
            }
        }
        return ans;
    }
}
