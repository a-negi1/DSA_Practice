class Pair{
    int distance;
    int[] points;
    
    Pair(int a,int []b ){
        this.distance = a;
        this.points = b;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue <Pair> pq = new PriorityQueue<>((a,b) -> b.distance - a.distance);

        for(int i=0;i<points.length;i++){
            int dist = calculate(points[i][0],points[i][1]);
            pq.add(new Pair(dist,points[i]));

            if(pq.size()>k){
                pq.poll();
            }

        }

        int [][] res = new int[k][2] ;
        for(int i=0;i<k;i++){
            res[i] = pq.poll().points;
        }
        return res;
    }

    int calculate(int x, int y){
        return x*x + y*y ;
    }
}