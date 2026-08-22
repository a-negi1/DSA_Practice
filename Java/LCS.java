// recursive solution 
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        
        return solve(text1,text2,0,0);
    }

    int solve(String t1,String t2,int i,int j){
        if(i==t1.length() || j ==t2.length() ){
            return 0;
        }

        if(t1.charAt(i) == t2.charAt(j)){
                   return  1+solve(t1,t2,i+1,j+1);
                }

                int c1 = solve(t1,t2,i,j+1);
                int c2 = solve(t1,t2,i+1,j);
                return Math.max(c1,c2);
                
            }
}


//Memoization(top down)

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n =  text1.length();
        int m = text2.length();
        int dp[][] = new int[n][m]; 

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        } 
        
        return solve(text1,text2,0,0,dp);
    }

    int solve(String t1,String t2,int i,int j,int[][]dp){
        if(i==t1.length() || j ==t2.length() ){
            return 0;
        }

            if(dp[i][j]!=-1){
                return dp[i][j];
            }
            if(t1.charAt(i) == t2.charAt(j)){
                   return dp[i][j] = 1+solve(t1,t2,i+1,j+1,dp);
                }

                int c1 = solve(t1,t2,i,j+1,dp);
                int c2 = solve(t1,t2,i+1,j,dp);
                return dp[i][j]=Math.max(c1,c2);
                
            }
}

//Tabulation
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n =  text1.length();
        int m = text2.length();
        int dp[][] = new int[n+1][m+1]; 

        
        
       for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){

                if(text1.charAt(i)== text2.charAt(j)){
                   dp[i][j] = 1+ dp[i+1][j+1];
               }
               else{
                dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
               }
            }

        
       } 

    
        return dp[0][0];
        
    }

        
}

