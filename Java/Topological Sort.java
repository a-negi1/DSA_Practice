class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList <ArrayList<Integer>> adj = new ArrayList<>();
       
        int indeg[] =  new int[V];
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            
            adj.get(src).add(dest);
            indeg[dest]++;
        }
        
        
        Queue <Integer>  q = new LinkedList<>();
        for(int i=0;i<V ;i++){
                if(indeg[i] == 0){
                   q.offer(i);
               }
            }
        ArrayList  <Integer> res = new ArrayList<>();       
        while(!q.isEmpty()){
            int node = q.poll();
            
            res.add(node);
            for(int i=0;i<adj.get(node).size();i++){
                int neigh = adj.get(node).get(i);
                
               indeg[neigh]--;
               
               if(indeg[neigh]==0){
                   q.offer(neigh);
               }
            }
            
            
        }
        return res;
    }
}