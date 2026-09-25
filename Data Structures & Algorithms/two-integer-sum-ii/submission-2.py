class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        i = 1
        j = len(numbers)
        while i < j:
            s = numbers[i - 1] + numbers[j - 1]
            if s == target:
                return [i, j]
            elif s < target:
                i += 1
            elif s > target:
                j -= 1
        return -1