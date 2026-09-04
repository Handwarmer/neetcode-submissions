class Twitter {
    Map<Integer, List<int[]>> tweets = new HashMap<>();
    Map<Integer, Set<Integer>> followers = new HashMap<>();
    int time = 0;
    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[]{tweetId, time++});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // int[] - {tweetId, userId, tweetIdx, tweetTime}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[3] - a[3]);
        Set<Integer> users = new HashSet<>(followers.getOrDefault(userId, new HashSet<>()));
        users.add(userId); // include user itself
        for (Integer uid : users) {
            if (!tweets.containsKey(uid)) continue;
            List<int[]> ts = tweets.get(uid);
            int tweetIdx = ts.size() - 1;
            int[] tweet = ts.get(tweetIdx);
            pq.add(new int[]{tweet[0], uid, tweetIdx, tweet[1]});
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty() && res.size() < 10) {
            int[] cur = pq.poll();
            res.add(cur[0]);
            cur[2] --;
            if (cur[2] >= 0) {
                int[] tweet = tweets.get(cur[1]).get(cur[2]);
                cur[0] = tweet[0];
                cur[3] = tweet[1];
                pq.add(cur);
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followers.putIfAbsent(followerId, new HashSet<>());
        followers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId))
            followers.get(followerId).remove(followeeId);
    }
}
