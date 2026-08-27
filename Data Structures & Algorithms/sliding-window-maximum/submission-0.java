class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<int[]> dq = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < k; i ++) {
            while (!dq.isEmpty() && nums[i] >= dq.peekLast()[1]) dq.pollLast();
            dq.addLast(new int[]{i, nums[i]});
        }
        int s = 0;
        for (int e = k-1; e < nums.length - 1;) {
            ans[s] = dq.peekFirst()[1];
            s ++; e ++;
            if (dq.peekFirst()[0] == s - 1) dq.pollFirst();
            while(!dq.isEmpty() && nums[e] >= dq.peekLast()[1]) dq.pollLast();
            dq.addLast(new int[]{e, nums[e]});
        }
        ans[s] = dq.peekFirst()[1];
        return ans;
    }
}
