//recursive sol
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int k= 2;
        int gain = solve (prices,n,0,k);

        return gain;
    }

    int solve(int []prices,int n,int i,int target){

   
    
    if (i==n || target ==0){
        return 0;
    }
    if (target == 2){
        int c1=solve(prices,n,i+1,target-1 )-prices[i];
        int c2= solve(prices,n,i+1,target);

        return Math.max(c1,c2);
       
    }
    else{
        

       int c1=solve (prices,n,i+1,2)+prices[i];
       int c2 =solve(prices,n,i+1,target);

       return Math.max(c1,c2);
    }
    
    
}
}

// memoization

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int k= 2;
        int dp[][] = new int[n][k+1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int gain = solve (prices,n,0,k,dp);
        
        return gain;
    }

    int solve(int []prices,int n,int i,int target,int dp[][]){

   
    
    if (i==n || target ==0){
        return 0;
    }

    if( dp[i][target]!=-1){
        return dp[i][target];
    }
    if (target == 2){
        int c1=solve(prices,n,i+1,target-1,dp )-prices[i];
        int c2= solve(prices,n,i+1,target,dp);

        return dp[i][target]= Math.max(c1,c2);
       
    }
    else{
        

       int c1=solve (prices,n,i+1,2,dp)+prices[i];
       int c2 =solve(prices,n,i+1,target,dp);

       return dp[i][target]= Math.max(c1,c2);
    }
    
    
}
}

// tabulation

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int k= 2;
        int dp[][] = new int[n+1][k+1];

        dp[n][k] = 0;

        for(int i=n-1;i>=0;i--){
            int buy = dp[i+1][1] - prices[i];
            int skipbuy = dp[i+1][2];

            dp[i][2] = Math.max(buy,skipbuy);

            int sell = dp[i+1][2] + prices[i];
            int skipsell = dp[i+1][1];
            dp[i][1] = Math.max(sell,skipsell);
        }
        return dp[0][2];
    }

       
}


