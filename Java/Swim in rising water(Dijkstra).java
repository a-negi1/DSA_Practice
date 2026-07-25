class Solution {
    public int swimInWater(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
      int [][] dis = new int[n][m];
       
      for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            dis[i][j] = Integer.MAX_VALUE;

        }
      }
         dis[0][0] = grid[0][0] ;
        Queue <int[]> q = new PriorityQueue<>((a,b)->a[0] - b[0]);
        q.offer(new int[]{grid[0][0],0,0});

        int x[] = {1,-1,0,0};
        int y[] = {0,0,1,-1};
        while(!q.isEmpty()){
            int [] p = q.poll();
            int time= p[0];
            int r = p[1];
            int c = p[2];

            if(r == n-1 && c == m-1 ){
                return time;
            }

            if(time> dis[r][c]){
                continue;
            }
        
        for(int k=0;k<4;k++){
            int row = r+ x[k];
            int col = c+y[k];
             if(valid(row,col,n,m)){
            

            int max = Math.max(grid[row][col],time);

            if(max < dis[row][col]){
                dis[row][col] = max;
                q.offer(new int[]{dis[row][col],row,col});
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