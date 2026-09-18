class Pair{
    int count;
    int tweetId;
    public Pair(int count,int tweetId){
        this.count=count;
        this.tweetId=tweetId;
    }
}
class Twitter {
    int count=1;
    HashMap<Integer,HashSet<Integer>> followMap;                            HashMap<Integer,ArrayList<Pair>> tweetMap;
        
    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        ArrayList<Pair> n;
        if(tweetMap.containsKey(userId)){
            n= tweetMap.get(userId);     
        }else{
            n = new ArrayList<>();   
        }
        n.add(new Pair(count++,tweetId));
        tweetMap.put(userId,n);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair a,Pair b){
                if(a.count>b.count){
                    return -1;
                }else if(a.count<b.count){
                    return 1;
                }else{
                    return 0;
                }
            }
        });
        ArrayList<Integer> res = new ArrayList<>();
        if(tweetMap.containsKey(userId))
        for(Pair p : tweetMap.get(userId)){
            queue.add(p);
        }
        if(followMap.containsKey(userId))
        for(int i : followMap.get(userId)){
            for(Pair p : tweetMap.get(i)){
                queue.add(p);
            }
        }
        while(!queue.isEmpty() && res.size()<10){
            res.add(queue.poll().tweetId);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        HashSet<Integer> n;
        if(followMap.containsKey(followerId)){
            n = followMap.get(followerId);     
        }else{
            n = new HashSet<>();   
        }
        n.add(followeeId);
        followMap.put(followerId,n);
    }
    
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> n;
        if(followMap.containsKey(followerId)){
            n = followMap.get(followerId);     
        }else{
            return;
        }
        n.remove(followeeId);
        followMap.put(followerId,n);
    }
}
