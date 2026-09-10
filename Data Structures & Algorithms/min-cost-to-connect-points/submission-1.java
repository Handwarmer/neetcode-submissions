class Solution {
    public int minCostConnectPoints(int[][] points) {
        int[] minDist = new int[points.length];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;
        Set<Integer> added = new HashSet<>();
        added.add(0);
        int cur = 0, ans = 0;
        while (added.size() < points.length) { //循环直到所有点加入added
            int curMinDist = Integer.MAX_VALUE;
            int curMin = 0;
            for (int i = 0; i < points.length; i ++) {
                if (added.contains(i)) continue;
                int distToCur = Math.abs(points[cur][0]-points[i][0]) + Math.abs(points[cur][1]-points[i][1]);
                minDist[i] = Math.min(minDist[i], distToCur);
                if (minDist[i] < curMinDist) {
                    curMinDist = minDist[i];
                    curMin = i;
                }
            }
            ans += curMinDist;
            cur = curMin;
            added.add(curMin);
        }
        return ans;
    }
}
