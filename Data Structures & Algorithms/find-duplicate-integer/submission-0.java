class Solution {
    public int findDuplicate(int[] nums) {
        // since member of nums are in [1,n] range, which is also the index of the array
        // treat each member as an index to jump to next member, a linked list
        // since there is duplicate, there has to bee a loop in the linked list
        // problem becomes finding entry point to the loop
        int fast = 0, slow = 0;
        do {
            fast = nums[fast];fast = nums[fast];
            slow = nums[slow];
        } while (fast != slow);
        int slow2 = 0;
        do {
            slow = nums[slow];
            slow2 = nums[slow2];
        } while (slow != slow2);
        return slow2;
    }
}
