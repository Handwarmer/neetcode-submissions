class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:    # gain[i] = gas[i] - cost[i]
        # total gain < 0
        # 整个环的资源都不够, 绝对无解
        if sum(gas) < sum(cost):
            return -1
        
        # total gain >= 0
        # 整个环的资源总量够
        # 虽然某些起点会因为“资源来得太晚”而失败
        # 但一定可以把起点移动到一个合适的位置
        # 让正的资源先积累起来，再承担后面的负数
        # Gas Station 真正的问题不是“油够不够”，而是“油出现的顺序对不对”。
        # greedy 找 start 解决的是“从哪里开始，才能把这个顺序安排成过程中不欠油”。
        curGas = 0
        ans = 0
        for i in range(len(gas)):
            curGas += gas[i] - cost[i]
            if curGas < 0:
                ans = i+1
                curGas = 0
        
        return ans