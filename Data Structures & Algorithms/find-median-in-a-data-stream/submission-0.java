class MedianFinder {
    PriorityQueue<Integer> smallHalf = new PriorityQueue<>();
    PriorityQueue<Integer> largeHalf = new PriorityQueue<>((a, b) -> b - a);
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        smallHalf.add(num);
        largeHalf.add(smallHalf.poll());
        if (smallHalf.size() < largeHalf.size())
            smallHalf.add(largeHalf.poll());
    }
    
    public double findMedian() {
        if (smallHalf.size() > largeHalf.size()) return smallHalf.peek();
        return (double) (smallHalf.peek() + largeHalf.peek()) / 2;
    }
}
