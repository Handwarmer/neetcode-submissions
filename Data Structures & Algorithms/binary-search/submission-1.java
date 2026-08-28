// 精确找target模版
// public int search(int[] nums, int target) {
//     int l = 0, r = nums.length - 1;      // 闭区间 [l, r]
//     while (l <= r) {                      // 注意 <=
//         int m = l + (r - l) / 2;
//         if (nums[m] == target) return m;
//         else if (nums[m] < target) l = m + 1;   // 小了 → 往右
//         else r = m - 1;                          // 大了 → 往左
//     }
//     return -1;                            // 没找到
// }

class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return m;
            else if (nums[m] < target) l = m + 1;
            else if (nums[m] > target) r = m - 1;
        }
        return -1; 
    }
}
