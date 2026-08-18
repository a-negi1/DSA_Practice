class Solution {
    static boolean isSubsetSum(int arr[], int sum) {
        int n=arr.length;
        Boolean dp[][] = new Boolean[n+1][sum+1];
        
        
        return fun(arr,dp,0,n,sum);
    }
    
    static Boolean fun(int []a,Boolean[][] dp,int i,int n,int sum ){
        if(i == n){
            if(sum == 0 ){
                return true;
            }
            else{return false;}
        }
        
        if(dp[i][sum] !=null){
            return dp[i][sum];
        }
        
        if(a[i]>sum){
            return dp[i][sum] = fun(a,dp,i+1,n,sum); 
        }
        
        Boolean c1=fun(a,dp,i+1,n,sum -a[i]);
        Boolean c2=fun(a,dp,i+1,n,sum);
        
        return dp[i][sum] = c1 || c2;
    }
}