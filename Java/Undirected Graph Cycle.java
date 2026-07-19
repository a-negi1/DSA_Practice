class Solution {
    public boolean isCycle(int V, int[][] edges) {
      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
      ArrayList<Boolean> vis = new ArrayList<>(Collections.nCopies(V,false));
      
      for(int i=0;i<V;i++){
          adj.add(new ArrayList<>());
      }
        
      
      for(int i = 0 ;i<edges.length;i++){
          int src = edges[i][0];
          int dest = edges[i][1];
          
          adj.get(src).add(dest);
          adj.get(dest).add(src);
          
      }
      for(int i=0;i<V;i++){
          if(vis.get(i) == false){
              dfs(adj,V,i,-1,vis);
          }
      }
      
      return cycle;
      }
    Boolean cycle = false;
    
    void dfs (ArrayList<ArrayList<Integer>> adj,int n,int node,int parent , ArrayList<Boolean> vis){
        
        vis.set(node,true);
        
        for(int i =0;i<adj.get(node).size();i++){
            int neigh = adj.get(node).get(i);
            
            if(vis.get(neigh) == true && parent != neigh){
                cycle = true;
            }  
            
            if(vis.get(neigh) == false ){
                dfs(adj,n,neigh,node,vis);
            }
            
        }
    }
}