class Solution {
    public int shortestPath(int V, int[][] edges, int src, int dest) {
        int n = edges.length;
        int m = edges[0].length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList <Integer> vis = new ArrayList<>(Collections.nCopies(V,0));
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<n;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        ArrayList <Integer> res = new ArrayList<>(Collections.nCopies(V,-1));
        
        Queue <int[]> q= new LinkedList<>();
        q.offer(new int[]{src,0});
        vis.set(src,1);
        
        while(!q.isEmpty()){
            int [] p = q.poll();
            int node = p[0];
            int dis = p[1];
            
            res.set(node,dis);
            
            for(int j=0;j<adj.get(node).size();j++){
                int neigh = adj.get(node).get(j);
                
                if(vis.get(neigh) == 0){
                    q.offer(new int[]{neigh,dis+1});
                    vis.set(neigh,1);
                }
            }
        }
        return res.get(dest);
    }
    
   
}