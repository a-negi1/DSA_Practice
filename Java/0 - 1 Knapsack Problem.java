class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        
        int[][]dp = new int[n][W+1];
        
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve( 0 ,val,wt,dp,W );
        
    }
   
    
    int solve(int i ,int []val,int wt[] ,int[][]dp,int cap) {
        
        if(i == val.length){
            return 0;
        }
        if (dp[i][cap] != -1) {
            return dp[i][cap];
        }
        
        if(wt[i]>cap){
            return dp[i][cap] = solve(i+1,val,wt,dp,cap);
        }
        
    
    
    int a1= val[i] + solve(i+1,val,wt,dp,cap-wt[i]) ;
    int a2= solve(i+1,val,wt,dp,cap) ;
    
    return dp[i][cap]=Math.max(a1,a2);
    
    }
}
 