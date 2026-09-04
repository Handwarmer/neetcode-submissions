class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        backtrack(new ArrayList<>(), new HashSet<>());
        return res;
    }
    void backtrack(List<Integer> cur, Set<Integer> used) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i ++) {
            if (!used.add(i)) continue;
            cur.add(nums[i]);
            backtrack(cur, used);
            used.remove(i);
            cur.remove(cur.size()-1);
        }
    }
}
