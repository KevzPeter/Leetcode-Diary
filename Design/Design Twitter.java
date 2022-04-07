class Twitter {
    HashMap<Integer, Set<Integer>> followMap;
    ArrayList<Integer> tweets;
    HashMap<Integer, Integer> tweetMap;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        tweets = new ArrayList<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.add(tweetId);
        tweetMap.put(tweetId, userId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        for (int i = tweets.size() - 1; i >= 0 && newsFeed.size() < 10; i--) {
            int tweetId = tweets.get(i);
            int op = tweetMap.get(tweetId);
            Set<Integer> follows = followMap.get(userId);
            if ((follows != null && follows.contains(op)) || op == userId) {
                newsFeed.add(tweetId);
            }
        }
        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        if (followMap.get(followerId) == null) {
            followMap.put(followerId, new HashSet<>());
        }
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.get(followerId) == null)
            return;
        followMap.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */