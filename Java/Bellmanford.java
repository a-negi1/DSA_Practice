class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        
        int[] res = new int[V];
        
        for(int i =0;i<V;i++){
            res[i] = (int)(1e8);
            
        }
        res[src] = 0;
        for(int i=0;i<V-1;i++){
            for(int j =0;j<edges.length;j++){
            int u = edges[j][0];    
            int v = edges[j][1];
            int wt = edges[j][2];
            
            if(res[u]!=(int)(1e8) && res[v] > res[u]+ wt){
                res[v] = res[u]+ wt;
            }
            }
            
            
            
        }
        
        for(int j=0;j<edges.length ;j++){
          
                int u = edges[j][0];    
                int v = edges[j][1];
                int wt = edges[j][2];
            
            if(res[u]!=(int)(1e8) && res[v] > res[u]+ wt){
                return new int[]{-1};
            }
        }
        return res;
    }
}
