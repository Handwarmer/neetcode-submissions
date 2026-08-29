class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 假设两个数组合并成一个，并且重新排过序了，那么
        // 如果数组长度是奇数，median就是最中间的数
        // 如果数组长度为偶数，median就是最中间两个数相加再除二
        // 但要是真合并再排序，就是O(nlogn)了
        // 不用真的合并。假设合并后的数组分成左右两半
        // 只要搞清，每个数组里的哪一部分会到合并后的左半
        // 假设合并后的左半共有half个元素
        // 只要找出两个数组A中的前i个元素，B中前j=half-i个元素
        // 使得这些找出的元素恰好为左半中应有的元素即可，也就是通过二分找出i的值
        // 如果把更长的那个数组当作A去找i的话，B上对应的half-i的最大值就是half
        // 由于half是合并后数组的长度的一半，会大于B的长度，就越界了
        // 因此，把更短的那个数组当作A去找i
        // 找到符合条件的i的情况应该是，A[i] <= B[j+1]
        int[] A = nums1.length > nums2.length ? nums2 : nums1;
        int[] B = nums1.length > nums2.length ? nums1 : nums2;
        int AL = A.length, BL = B.length;
        int l = 0, r = A.length;
        // 如果总长是5，我们希望half是3（因此+1），这样第三个元素就是要找的
        // 如果总长是6，half无论是否+1都是3。第3，4个元素就是要找的
        int half = (nums1.length + nums2.length + 1) / 2;
        int ans = 0;
        while (l <= r) {
            int i = l + (r - l) / 2;
            int j = half - i;
            /* 防止越界，比如i为0，取A[i-1]就越界了 */
            int aL = (i == 0) ? Integer.MIN_VALUE : A[i-1];
            int aR = (i == AL) ? Integer.MAX_VALUE : A[i];
            int bL = (j == 0) ? Integer.MIN_VALUE : B[j-1];
            int bR = (j == BL) ? Integer.MAX_VALUE : B[j];
            if (aL <= bR && bL <= aR) {
                if ((AL + BL) % 2 == 1) return Math.max(aL, bL);
                return (Math.max(aL, bL) + Math.min(aR, bR)) / 2.0;
            } else if (aL > bR){
                r = i - 1;
            } else {
                l = i + 1;
            } 
        }
        return 0.0;
    }
}
