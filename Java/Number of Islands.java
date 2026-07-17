class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
       
        int count = 0;
        
        int [][]vis = new int[n][m];
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]== '1' && vis[i][j]==0 ){
                dfs(grid,i,j,n,m,vis);
                count ++;
                }
            }
            
        }
        return count;
    }

    int []x = {1,-1,0,0};
    int []y = {0,0,1,-1};
    void dfs(char [][] a,int i,int j,int n,int m,int [][] vis){
        vis [i][j] = 1;
        for(int k=0;k<4;k++){
            int row = i+ x[k];
            int col =  j+ y[k];

            if(isValid(row,col,n,m) && a[row][col] == '1' && vis[row][col] == 0 ){
                dfs(a,row,col,n ,m,vis);
            }
        }
        
    }
    
    boolean isValid(int i,int j,int n,int m){

    if(i<0 || i>=n || j<0|| j>=m){
        return false;
    }
    
        return true;
    
    
 }
}
    
