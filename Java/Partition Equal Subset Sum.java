class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum =0;
        for(int i=0;i<nums.length;i++){
          sum += nums[i];
        }

        if(sum%2 !=0){
            return false;
        }
        int ans = sum / 2;
        int n= nums.length;
        boolean dp[][]= new boolean[n+1][ans+1];

         for(int i=0;i<=n;i++){

            dp[i][0] = true;

        }


        

        for(int i=n-1;i>=0;i--){
            for(int s=1;s<=ans;s++){
                if(nums[i]>s){
                    dp[i][s] = dp[i+1][s];
                }
                else{

                dp[i][s] = dp[i+1][s] || dp[i+1][s-nums[i]];}
                
            }
        }

        return dp[0][ans];
    }
}