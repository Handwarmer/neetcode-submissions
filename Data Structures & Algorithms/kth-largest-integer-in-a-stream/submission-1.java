class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int n : nums) {
            add(n);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if (pq.size() > k) pq.poll();
        return pq.peek();
    }
}
