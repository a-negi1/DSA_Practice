class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int [][]dp= new int[n][n+1] ;

        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return solve(nums,0,-1,dp);
        

    }

    int solve(int []nums,int initial,int prev,int[][] dp){
        int n = nums.length;
        if(initial == n){
            return 0;
        }
 
        if(dp[initial][prev+1]!=-1){
            return dp[initial][prev+1];
        }
        int c1=0; 
        if( prev == -1 || nums[initial]>nums[prev]){
            c1 = 1+ solve(nums,initial+1,initial,dp);
            

           
        }
        int c2 = solve(nums,initial+1,prev,dp);
        return dp[initial][prev+1] = Math.max(c1,c2);
    
    }
}