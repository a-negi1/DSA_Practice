class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<int[]>> adj =new ArrayList();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        int[] dis = new int [V];
        
        for(int i=0;i<V;i++)
        {
            dis[i] = Integer.MAX_VALUE;
        }
        
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            
            adj.get(u).add(new int[]{v,wt});
            adj.get(v).add(new int[]{u,wt});
            
        }
        
        Queue <int[]> q = new PriorityQueue<>((a,b)-> a[1] - b[1] );
        dis[src] =0;
        q.offer(new int[]{src,0});
        
        while(!q.isEmpty()){
            int [] p = q.poll();
            int node= p[0];
            int d = p[1] ;
            if(d>dis[node]){
                continue;
            }
            for(int i =0;i<adj.get(node).size();i++){
                int[] n = adj.get(node).get(i);
                int neigh = n[0];
                int  weight = n[1];
                
                if(weight + d < dis[neigh]){
                    dis[neigh] = weight + d;
                    q.offer(new int[]{neigh,dis[neigh]});
                    
                }
                
            }
        }
            
            
            for(int i=0;i<V;i++){
                if(dis[i] == Integer.MAX_VALUE){
                    dis[i] = -1;
                }
            
        }
        return dis;
    }
}