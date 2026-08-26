class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i ++) {
            if (nums[i] > 0) break;                          // 可选:剪枝
            if (i > 0 && nums[i] == nums[i - 1]) continue;   // Bug 4:跳过重复 i
            int l = i+1, r = nums.length - 1, tar = 0 - nums[i];
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == tar) {
                    List<Integer> al = List.of(nums[i], nums[l], nums[r]);
                    ans.add(al);
                    l ++; r --;
                    while (l < r && nums[l] == nums[l - 1]) l++;  // Bug 4:跳重复 l
                    while (l < r && nums[r] == nums[r + 1]) r--;  // Bug 4:跳重复 r
                } else if (sum < tar) l ++;
                else if (sum > tar) r --;
            }
        }
        return ans;
    }
}
