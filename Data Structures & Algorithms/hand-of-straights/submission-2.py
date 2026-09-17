class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        count = Counter(hand)
        hand.sort()

        minHeap = list(count.keys())
        heapq.heapify(minHeap)

        while minHeap:
            first = minHeap[0]

            for card in range(first, first + groupSize):
                if card not in count or count[card] <= 0:
                    return False
                
                count[card] -= 1

                if count[card] == 0:
                    if card == minHeap[0]:
                        heapq.heappop(minHeap)
        
        return True