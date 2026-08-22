//recursive
class Solution {
    public int uniquePaths(int m, int n) {
        
        return solve(0,0,m,n);
    }

    int solve(int i,int j,int m,int n){
        if( i==m-1 || j==n-1){
            return 1;
        }

        if( i<0 || i>=m || j<0|| j>=n){
            return 0;
        }

        return solve(i,j+1,m,n) + solve(i+1,j,m,n);
    }
}
