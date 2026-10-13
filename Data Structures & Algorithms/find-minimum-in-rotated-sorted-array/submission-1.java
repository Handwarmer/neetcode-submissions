class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, ans = 0;
        while (l <= r) {
            int m = l + (r-l)/2;
            if (inRotated(nums, m)) {
                l = m + 1;
            } else {
                ans = m;
                r = m - 1;
            }
        }
        return nums[ans];
    }
    private boolean inRotated(int[] nums, int m) {
        return nums[m] > nums[nums.length-1];
    }
}
