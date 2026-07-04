class Solution {
    boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
       return ans(s,0,s.length()-1)  ;
    }
    
    boolean ans(String s,int low,int high){
        if(low>=high){
            return true;
        }
        
        if(s.charAt(low) != s.charAt(high)){
            return false;
        }
        
       return ans(s,low+1,high-1 );
    }
}