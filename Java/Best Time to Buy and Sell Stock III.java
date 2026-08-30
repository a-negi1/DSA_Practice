// recursive 
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int k = 4;
        return solve(prices,0,k,n);
    }

    int solve(int prices[],int i,int k,int n ){
        
        if(k ==0 || i==n){
            return 0;
        }

        if(k % 2==0){
           int buy = solve(prices,i+1,k-1,n)-prices[i];
           int notbuy = solve(prices,i+1,k,n);

           return Math.max(buy,notbuy);
        }

        else{
            int sell  =  solve(prices,i+1,k-1,n)+prices[i];
            int notsell = solve(prices,i+1,k,n);
            return Math.max(sell,notsell);
             
        }

    }
}

//memoization
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int k = 4;

        int dp [][]= new int[n+1][k+1];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(prices,0,k,n,dp);
    }

    int solve(int prices[],int i,int k,int n,int [][]dp ){
        
        if(k ==0 || i==n){
            return 0;
        }
        if(dp[i][k]!=-1){
            return dp[i][k];
        }
        if(k % 2==0){
           int buy = solve(prices,i+1,k-1,n,dp)-prices[i];
           int notbuy = solve(prices,i+1,k,n,dp);

           return dp[i][k]= Math.max(buy,notbuy);
        }

        else{
            int sell  =  solve(prices,i+1,k-1,n,dp)+prices[i];
            int notsell = solve(prices,i+1,k,n,dp);
            return dp[i][k]= Math.max(sell,notsell);
             
        }

    }
}

//tabulation

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int k = 4;

        int dp [][][]= new int[n+1][k+1][2];

        
        
        for(int i=n-1;i>=0;i--){
            for(int trans=1;trans<=k;trans++){
                int buy = dp[i+1][trans-1][0] - prices[i];
                int notbuy = dp[i+1][trans][1];
            

                dp[i][trans][1] = Math.max(buy,notbuy);

                int sell = dp[i+1][trans-1][1]+prices[i];
                int notsell = dp[i+1][trans][0];

            dp[i][trans][0] = Math.max(sell,notsell);
            }
            
        }
        
        return dp[0][k][1];
    }

   
}