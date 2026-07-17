
class Solution {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        
        List <List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            
            
            int src = edges[i][0];
            int dest = edges[i][1];
            
            adj.get(src).add(dest);
            adj.get(dest).add(src);
            
       
        
    }
    
    return adj;
    }
}