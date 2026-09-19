class Pair{
    int task;
    int count;
    int time;
    public Pair(int task,int count,int time){
        this.task=task;
        this.count=count;
        this.time=time;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair a,Pair b){
                if(a.count>b.count){
                    return -1;
                }else if(a.count<b.count){
                    return 1;
                }else{
                    if(a.time<b.time){
                        return -1;
                    }else if(a.time>b.time){
                        return 1;
                    }else{
                        return 0;
                    }
                }
            }
        });
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : tasks){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch : map.keySet()){
            maxHeap.add(new Pair(ch,map.get(ch),0));
        }
        PriorityQueue<Pair> q = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair a,Pair b){
                
                    if(a.time<b.time){
                        return -1;
                    }else if(a.time>b.time){
                        return 1;
                    }else{
                        return 0;
                    }
                
            }
        });
        int i=0;
        while(!maxHeap.isEmpty() || !q.isEmpty()){
            while(!q.isEmpty() && q.peek().time<i){
                maxHeap.add(q.poll());
            }
            if(!maxHeap.isEmpty()){
                Pair curr = maxHeap.poll();
                curr.count--;
                if(curr.count>0){
                    curr.time=i+n;
                    q.add(curr);
                }
            }
            i++;
        }
        return i;
    }
}
