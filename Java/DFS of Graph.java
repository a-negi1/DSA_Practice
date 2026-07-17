class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        
        int n = adj.size();
        ArrayList<Boolean> vis = new ArrayList<>(Collections.nCopies(n,false));
        
        solve(adj,0,res,vis);
        return res;
        
    }
    
    void solve(ArrayList<ArrayList<Integer>>adj,int node,ArrayList<Integer>res,ArrayList <Boolean> vis){
        res.add(node);
        
        vis.set(node,true);
        
        for(int i=0;i<adj.get(node).size();i++){
            int neigh = adj.get(node).get(i);
            
            if(vis.get(neigh) == false){
                solve(adj,neigh,res,vis);
            }
        }
        
    }
}