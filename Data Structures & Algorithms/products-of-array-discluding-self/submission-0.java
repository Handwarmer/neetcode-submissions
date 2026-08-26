class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length]; prefix[0] = 1;
        int[] suffix = new int[nums.length]; suffix[nums.length-1] = 1;
        int res = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            prefix[i] = res;
            res = res * nums[i];
        }
        res = nums[nums.length-1];
        for (int i = nums.length - 2; i >= 0; i --) {
            suffix[i] = res;
            res = res * nums[i];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            result[i] = prefix[i] * suffix[i];
        }
        return result;
    }
}  
