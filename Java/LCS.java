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












