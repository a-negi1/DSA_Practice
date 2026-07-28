class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    int [] dis = new int[n];
    Arrays.fill(dis,(int)1e8);
    
    dis[src] = 0;
    for(int i=0;i<=k;i++){
        int [] temp = Arrays.copyOf(dis,n);
        for(int j=0;j<flights.length;j++){
            int u= flights[j][0] ; 
            int v = flights[j][1];
            int wt = flights[j][2];
            if( dis [src] != 1e8 && temp[v]>dis[u] + wt){
                temp[v] = dis[u] + wt;
                
             }

        }
        dis =temp;

    }
    
    return dis[dst] == 1e8 ? -1 : dis[dst];
    }
}