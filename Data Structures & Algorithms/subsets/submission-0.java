class Solution {
    int[] nums;
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        backtrack(0, new ArrayList<>());
        return res;
    }
    void backtrack(int start, List<Integer> cur) {
        res.add(new ArrayList<>(cur));
        for (int i = start; i < nums.length; i ++) {
            cur.add(nums[i]);
            backtrack(i+1, cur);
            cur.remove(cur.size()-1);
        }
    }
}
