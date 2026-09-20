class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        heap = []
        m = defaultdict(int)
        for n in nums:
            m[n] += 1
        for key, val in m.items():
            heapq.heappush(heap, [val, key])
            if len(heap) > k:
                heapq.heappop(heap)
        return [key for _, key in heap]