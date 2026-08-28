class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, m = 0, originalStart = 0;
        while (l <= r) {
            m = l + (r - l)/2;
            if (isOriginal(nums, m)) {
                originalStart = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        if (target >= nums[originalStart] && target <= nums[nums.length-1]) {
            l = originalStart; r = nums.length - 1;
        } else {
            l = 0; r = originalStart - 1;
        }
        if (target > nums[nums.length-1]) {
            l = 0; r = originalStart - 1;
        }
        while (l <= r) {
            m = l + (r - l)/2;
            if (nums[m] == target) return m;
            if (nums[m] < target) l = m + 1;
            else if (nums[m] > target) r = m - 1;
        }
        return -1;
    }
    private boolean isOriginal(int[] nums, int m) {
        return nums[m] <= nums[nums.length-1];
    }
}
