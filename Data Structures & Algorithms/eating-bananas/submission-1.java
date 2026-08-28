/**
找比XXX大的最小值模版。也就是数组里的数对应的boolean值是单调的：
[F,F,F...F,T...T]
这时候要找的就是这个从F变成T的翻转点
class Solution {
    public int firstTrue(int[] nums) {
        int l = 0, r = nums.length - 1, ans = -1;   // ans = -1 表示全是 F、没有 T
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (isT(nums, m)) {   // m 是 T → 第一个 T 在 m 或更左
                ans = m;          // 先记下这个候选
                r = m - 1;        // 再往左找更早的 T（已记录，放心排除 m）
            } else {              // m 是 F → 第一个 T 在右边
                l = m + 1;        // 不记录
            }
        }
        return ans;               // 第一个 T 的下标
    }

    private boolean isT(int[] nums, int m) {
        // 返回T或者F的逻辑
    }
}
*/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;
        for (int p : piles) {
            r = Math.max(r, p);
        }
        int ans = 0;
        while (l <= r) {
            int m = l + (r - l)/2;
            if (canFinish(piles, h, m)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
    private boolean canFinish(int[] piles, int h, int m) {
        int t = 0;
        for (int p : piles) {
            t += p / m;
            t += p % m == 0 ? 0 : 1;
        }
        return t <= h;
    }
}
