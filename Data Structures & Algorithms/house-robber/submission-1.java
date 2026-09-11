class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        //prevNo 不抢前一个房子
        //prevYes 抢前一个房子
        int prevNo = 0;
        int prevYes = nums[0];
        for (int i = 1; i < n; i ++) {
            int curNo = Math.max(prevNo, prevYes);
            int curYes = prevNo + nums[i];
            prevNo = curNo;
            prevYes = curYes;
        }
        return Math.max(prevNo, prevYes);
    }
}
