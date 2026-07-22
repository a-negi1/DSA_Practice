class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int dis[][] = new int[n][m];

         for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                 dis[i][j] = Integer.MAX_VALUE ;
            }
           
         }
        
        int[] x = {1,-1,0,0};
        int[] y =  {0,0,-1,1};

        Queue <int[]> q = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        dis[0][0]= 0; 
        q.offer(new int[]{0,0,0});

        while(!q.isEmpty()){
            int []p = q.poll();
            int currEffort = p[0];
            int r = p[1];
            int c = p[2];
            
            if(r == n-1 && c == m-1){
                return currEffort;
            }

            if(currEffort > dis [r][c]){
                continue;
            }
            for(int k=0;k<4;k++){
                int newrow = r + x[k];
                int newcol = c + y[k];

                if(valid(newrow,newcol,n,m) ){
                    int diff = Math.abs(heights[r][c] - heights[newrow][newcol]);
                    int maxEffort = Math.max(currEffort,diff);

                    if(maxEffort < dis[newrow][newcol]){
                    dis[newrow][newcol] = maxEffort;
                    q.offer(new int[]{dis[newrow][newcol],newrow,newcol});
                }
                }

                
            }

        }
        return 0;
    }

    boolean valid(int i,int j, int n,int m){

        if(i<0 || i>=n || j < 0|| j>=m ){
            return false;
        }    
        return true;
    }
}