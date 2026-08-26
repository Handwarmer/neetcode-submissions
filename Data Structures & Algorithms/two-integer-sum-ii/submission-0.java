class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] == target)
                return new int[]{l+1, r+1};
            if (nums[l] + nums[r] < target) l ++;
            if (nums[l] + nums[r] > target) r --;
        }
        return null;
    }
}
