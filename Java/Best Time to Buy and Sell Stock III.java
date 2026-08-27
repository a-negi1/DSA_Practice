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