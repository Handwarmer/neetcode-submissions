class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        # 基本思路是维持一个maxHeap，heap里同时存元素和对应的index
        # 每当window移动时，检查堆顶的最大值对应的index是不是已经在
        # window之外了(index < s)，如果在的话就pop掉堆顶，直到堆顶
        # 仍在window内，此时堆顶就是当前window的最大值

        # 相比maxHeap的O(nlogn)，更优解是用一个单调递减队列
        # 保证队列头->尾是递减的，每次加元素从队尾加，然后检查队尾
        # 如果队尾小与当前要加的元素，就把队尾pop掉
        # 因为当前元素比队尾来的晚（index更大），又比队尾大的话，就
        # 意味着只要当前元素出现了，队尾的元素永远不可能是正确答案
        # 如此处理后，队头就是答案了
        # 当然每次移动依然要检查队头的index是否在window内，不在就pop
        dq = deque()
        ans = [0] * (len(nums) - k + 1)
        for i in range(k):
            cur = nums[i]
            while dq and dq[-1][1] <= cur:
                dq.pop()
            dq.append([i, cur])
        ans[0] = dq[0][1]
        for e in range(k, len(nums)):
            s = e - k + 1
            cur = nums[e]
            while dq and dq[-1][1] <= cur:
                dq.pop()
            dq.append([e, cur])
            while dq and dq[0][0] < s:
                dq.popleft()
            ans[s] = dq[0][1]
        return ans