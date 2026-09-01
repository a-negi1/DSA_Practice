//recursive
class Solution {
    public int minCost(int n, int[] cuts) {
        int len=cuts.length;
        ArrayList <Integer> a  = new ArrayList<>();
        a.add(0);
        for(int i=0;i<len;i++){
            a.add(cuts[i]);
        }
        
        a.add(n);
        Collections.sort(a);
        return solve(a,1,a.size()-2);
    }

    int solve(ArrayList <Integer>b,int i,int j){

        if(i>j){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int curr = b.get(j+1)  - b.get(i-1) + solve(b,i,k-1) + solve(b,k+1,j) ;
             min = Math.min(curr,min);
            
        }
        return min;
    }


}

//memoization

class Solution {
    public int minCost(int n, int[] cuts) {
        int len=cuts.length;
        ArrayList <Integer> a  = new ArrayList<>();

        
        a.add(0);
        for(int i=0;i<len;i++){
            a.add(cuts[i]);
        }
        
        a.add(n);
        Collections.sort(a);

        int[][] dp = new int[a.size()][a.size()];
        
        for(int i=0;i<a.size();i++ ){
            Arrays.fill(dp[i],-1);
        }  
        return solve(a,1,a.size()-2,dp);
    }

    int solve(ArrayList <Integer>b,int i,int j,int[][] dp){

        if(i>j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int curr = b.get(j+1)  - b.get(i-1) + solve(b,i,k-1,dp) + solve(b,k+1,j,dp) ;
             min = Math.min(curr,min);
            
        }
        return dp[i][j]= min;
    }


}

//tabulation

class Solution {
    public int minCost(int n, int[] cuts) {
        int len=cuts.length;
        ArrayList <Integer> a  = new ArrayList<>();

        
        a.add(0);
        for(int i=0;i<len;i++){
            a.add(cuts[i]);
        }
        
        a.add(n);
        Collections.sort(a);

        int[][] dp = new int[a.size()][a.size()];
        
        for(int i=len;i>=1;i-- ){
            for(int j=i;j<=len;j++ ){

                int min=Integer.MAX_VALUE;

                for(int k=i;k<=j;k++){
                    int curr = a.get(j+1)  - a.get(i-1) + dp[i][k-1] + dp[k+1][j] ;
                    min = Math.min(curr,min);
            
                }

             dp[i][j]= min;
            }
        }  
        return dp[1][len];

    }

}

