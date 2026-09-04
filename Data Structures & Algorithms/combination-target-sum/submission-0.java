class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;
    int target;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        backtrack(0, new ArrayList<>(), 0);
        return res;
    }
    void backtrack(int start, List<Integer> cur, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (sum > target) return;
        for (int i = start; i <nums.length; i ++) {
            cur.add(nums[i]);
            backtrack(i, cur, sum + nums[i]);
            cur.remove(cur.size()-1);
        }
    }
}
