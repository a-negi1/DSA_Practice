class Solution {
    public int spanningTree(int V, int[][] edges) {
        int n = edges.length;
        
        ArrayList <ArrayList<int[]>> adj= new ArrayList<>();
        
       
        
        
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            
                int u=edges[i][0];
                int v=edges[i][1];
                int wt=edges[i][2];
                
                adj.get(u).add(new int[]{v,wt});
                adj.get(v).add(new int[]{u,wt});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1] - b[1]);
        
         boolean []vis = new boolean[V];
         int mstsum = 0;
         
         pq.offer(new int[]{0,0});
         
         while(!pq.isEmpty()){
             int[] current = pq.poll();
             int node = current[0];
             int wt = current[1];
             
             if (vis[node]){
                 continue;
             }
             
             vis[node] = true;
             mstsum += wt;
             
             for(int j =0;j<adj.get(node).size();j++){
                 int [] neighbor = adj.get(node).get(j);
                 int adjnode = neighbor[0];
                 int adjwt = neighbor[1];
                 
                 if(!vis[adjnode]){
                     pq.offer(new int[]{adjnode,adjwt});
                 }
                 
             }
         }
         return mstsum;
    }
}
