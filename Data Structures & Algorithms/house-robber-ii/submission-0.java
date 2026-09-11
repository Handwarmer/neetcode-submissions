class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        // 跳过最后一个或第一个不抢，就变成了无环版本
        int skipLast = robLinear(nums, 0, n-1);
        int skipFirst = robLinear(nums, 1, n);
        return Math.max(skipLast, skipFirst);
    }

    public int robLinear(int[] nums, int s, int e) {
        int n = nums.length;
        //prevNo 不抢前一个房子
        //prevYes 抢前一个房子
        int prevNo = 0;
        int prevYes = nums[s];
        for (int i = s+1; i < e; i ++) {
            int curNo = Math.max(prevNo, prevYes);
            int curYes = prevNo + nums[i];
            prevNo = curNo;
            prevYes = curYes;
        }
        return Math.max(prevNo, prevYes);
    }
}
