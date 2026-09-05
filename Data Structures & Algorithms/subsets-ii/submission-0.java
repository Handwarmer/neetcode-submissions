class Solution {
    int[] nums;
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        backtrack(0, new ArrayList<>());
        return ans;
    }
    void backtrack(int start, List<Integer> cur) {
        ans.add(new ArrayList<>(cur));
        for (int i = start; i < nums.length; i ++) {
            if (i > start && nums[i] == nums[i-1]) continue;
            cur.add(nums[i]);
            backtrack(i+1, cur);
            cur.remove(cur.size()-1);
        }
    }
}
