class Pair{
    int x;
    int y;
    public Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> q = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair a,Pair b){
                double i=(a.x*a.x)+(a.y*a.y);
                double j=(b.x*b.x)+(b.y*b.y);
                if(i<j){
                    return -1;
                }else if(i>j){
                    return 1;
                }else{
                    return 0;
                }
            }
        });
        for(int i=0;i<points.length;i++){
            q.add(new Pair(points[i][0],points[i][1]));
        }
        int res[][] = new int[k][2];
        int i=0;
        while(k>0){
            Pair c = q.poll();
            res[i][0]=c.x;
            res[i][1]=c.y;
            i++;
            k--;
        }
        return res;
    }
}
