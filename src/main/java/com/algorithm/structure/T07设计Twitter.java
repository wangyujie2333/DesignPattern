package com.algorithm.structure;


import java.util.*;

/**
 * @author wangyuj
 * @date 2021/1/5
 **/
public class T07设计Twitter {
    private static int timestamp = 0;
    private HashMap<Integer, User> userMap = new HashMap<>();

    public static void main(String[] args) {
        T07设计Twitter twitter = new T07设计Twitter();
        twitter.follow(1, 2);
        twitter.follow(2, 1);

        twitter.postTweet(1, 1);
        twitter.postTweet(1, 2);
        twitter.postTweet(2, 3);
        twitter.postTweet(2, 4);
        List<Integer> newsFeed = twitter.getNewsFeed(1);
        System.out.println(newsFeed);
    }

    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User user = new User(userId);
            userMap.put(userId, user);
        }
        User user = userMap.get(userId);
        user.post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) return res;
        // 关注列表的用户 Id
        Set<Integer> users = userMap.get(userId).followed;
        // 自动通过 time 属性从大到小排序，容量为 users 的大小
        PriorityQueue<Tweet> pq = new PriorityQueue<>(users.size(), (a, b) -> (b.time - a.time));

        // 先将所有链表头节点插入优先级队列
        for (int id : users) {
            Tweet twt = userMap.get(id).head;
            if (twt == null) continue;
            pq.add(twt);
        }

        while (!pq.isEmpty()) {
            // 最多返回 10 条就够了
            if (res.size() == 10) break;
            // 弹出 time 值最大的（最近发表的）
            Tweet twt = pq.poll();
            res.add(twt.id);
            // 将下一篇 Tweet 插入进行排序
            if (twt.next != null)
                pq.add(twt.next);
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User user = new User(followerId);
            userMap.put(followerId, user);
        }
        if (!userMap.containsKey(followeeId)) {
            User user = new User(followeeId);
            userMap.put(followeeId, user);
        }
        userMap.get(followeeId).follow(followerId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followeeId)) {
            User user = userMap.get(followeeId);
            user.unfollow(followerId);
        }
    }

    class Tweet {
        private int time;
        private int id;
        private Tweet next;

        public Tweet() {
        }

        public Tweet(int time, int tweetId) {
            this.time = time;
            this.id = tweetId;
        }
    }

    class User {
        private final Set<Integer> followed = new HashSet<>();
        private int id;
        private Tweet head;

        public User() {
        }

        public User(int userId) {
            this.id = userId;
        }

        public void follow(int userId) {
            followed.add(userId);
        }

        public void unfollow(int userId) {
            if (this.id != userId) {
                followed.remove(userId);
            }
        }

        public void post(int tweetId) {
            Tweet tweet = new Tweet(tweetId, timestamp++);
            // 将新建的推文插入链表头
            // 越靠前的推文 time 值越大
            tweet.next = head;
            head = tweet;
        }
    }


}
