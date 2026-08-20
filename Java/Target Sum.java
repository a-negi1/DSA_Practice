class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int n =nums.length;
        int sum =0; 

        for(int i=0;i<n;i++){
            sum+=nums[i];
               }

    
        if (Math.abs(target)>sum || (sum+target)%2 != 0){
            return 0;
        }
        int s= (sum+target) /2 ;
       int dp[][] = new int[n+1][s+1];
       dp[n][0]=1;

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=s;j++){

                if(nums[i]>j){
                    dp[i][j] = dp[i+1][j];
                }
                else{
                dp[i][j]= dp[i+1][j]+ dp[i+1][j-nums[i]];
                }
            }
        }

        return dp[0][s];
    }
}