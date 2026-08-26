class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int n : nums) s.add(n);
        int ans = 0;
        for (int i = 0; i < nums.length; i ++) {
            int n = nums[i];
            if (s.contains(n-1)) continue;
            int len = 1;
            while (s.contains(n+1)) {
                len ++;
                n++;
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }
}
