class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int n : nums) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }
        List<Integer>[] l = new List[nums.length+1];
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            int num = e.getKey();
            int cnt = e.getValue();
            if (l[cnt] == null) l[cnt] = new ArrayList<Integer>();
            l[cnt].add(num);
        }
        int[] ans = new int[k];
        int idx = 0;
        for (int i = l.length-1; i >=0; i--) {
            List<Integer> al = l[i];
            if (al == null) continue;
            for (Integer num : al) {
                ans[idx++] = num;
                if (idx == k) return ans;
            }
        }
        return ans;
    }
}
