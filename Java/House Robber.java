class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
      int[][] map  = new int[n][2];

      for(int i=0;i<n;i++){
        Arrays.fill(map[i],-1);
      }

      return answer(0,1,nums,map);
    }

    int answer (int i,int free,int[] nums,int[][] dp){
        int n = nums.length;
       

        if(i==n){
            return 0;
        }

        
        if(dp[i][free] != -1 ){
            return dp[i][free];
        }
    
        if(free ==0 ){
            return dp[i][free]=answer(i+1,1,nums,dp);
        }
        

        int a = nums[i]+ answer(i+1,0,nums,dp);
        int b = answer(i+1,1,nums,dp);

         return dp[i][free] = Math.max(a,b);
        
    }
}