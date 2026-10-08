class Pair{
    int p;
    int s;
    public Pair(int p,int s){
        this.p=p;
        this.s=s;
    }
}
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> s  =new Stack<>();
        ArrayList<Pair> pos = new ArrayList<>();
        for(int i=0;i<position.length;i++){
            pos.add(new Pair(position[i],speed[i]));
        }
        Collections.sort(pos,new Comparator<Pair>(){
            @Override
            public int compare(Pair a,Pair b){
                if(a.p>b.p){
                    return -1;
                }else if(a.p<b.p){
                    return 1;
                }else{
                    return 0;
                }
            }
        });
        for(int i=0;i<pos.size();i++){
            double time = (double)(target-pos.get(i).p)/pos.get(i).s;
            if(!s.isEmpty() && time<=s.peek()){
                continue;
            }else{
                s.push(time);
            }
        }
        return s.size();
    }
}
