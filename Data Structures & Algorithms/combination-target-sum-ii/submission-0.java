class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int[] nums;
    int tar;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.nums = candidates;
        this.tar = target;
        Arrays.sort(nums);
        backtrack(0, new ArrayList<>(), 0);
        return ans;
    }
    void backtrack(int start, List<Integer> cur, int sum) {
        if (sum == tar) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < nums.length; i ++) {
            if (sum + nums[i] > tar) break;
            if (i > start && nums[i] == nums[i-1]) continue; //去重
            cur.add(nums[i]);
            backtrack(i+1, cur, sum + nums[i]);
            cur.remove(cur.size()-1);
        }
    }
}
