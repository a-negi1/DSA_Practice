class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        int[] dis = new int[n+1];

        for(int i=0;i<=n;i++){
            dis[i] = Integer.MAX_VALUE;
        }

        for(int i=0;i<times.length;i++){
            int u = times[i][0];
            int v=  times[i][1];
            int wt= times [i][2];

            adj.get(u).add(new int[]{v,wt});
        }
        Queue <int[]> q = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        dis[k]=0;
        q.offer(new int[]{k,0});

        while(!q.isEmpty()){
             int [] p = q.poll();

             int node= p[0];
             int wt = p[1];

             for(int i=0;i<adj.get(node).size();i++){
                int[] ni = adj.get(node).get(i);
                int neigh = ni[0];
                int weight = ni[1];

                if(wt + weight < dis[neigh]){
                    dis[neigh] = wt + weight;
                    q.offer(new int[]{neigh,dis[neigh]});
                }
             }
            
        }
        int maxdist =0;
        for(int i=1;i<=n;i++){
            if(dis[i] == Integer.MAX_VALUE){
                return -1;
            }
            else{
               
                maxdist=Math.max(maxdist,dis[i]);
            }
        }
        return maxdist;
    }
}