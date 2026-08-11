class Twitter {

    class pair {
        int first;
        int sec;

        pair(int first, int sec) {
            this.first = first;
            this.sec = sec;
        }
    }

    List<Set<Integer>> list;
    Map<Integer, List<pair>> map;
    int time;

    public Twitter() {
        list = new ArrayList<>();

        for (int i = 0; i < 501; i++) {
            list.add(new HashSet<>());
        }

        map = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        if(!map.containsKey(userId)) {
            map.put(userId, new ArrayList<>());
        }

        map.get(userId).add(new pair(tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.sec, a.sec)
        );

        if(map.containsKey(userId)) {
            for (pair tweet : map.get(userId)) {
                pq.offer(tweet);
            }
        }

        for(int followee : list.get(userId)) {

            if(!map.containsKey(followee)) {
                continue;
            }

            for(pair tweet : map.get(followee)) {
                pq.offer(tweet);
            }
        }

        List<Integer> ans = new ArrayList<>();

        int count = 0;

        while (!pq.isEmpty() && count < 10) {
            ans.add(pq.poll().first);
            count++;
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {
        list.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        list.get(followerId).remove(followeeId);
    }
}