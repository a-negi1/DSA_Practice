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

