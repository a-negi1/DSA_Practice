class Solution {
    
    public String removeCharacter(StringBuilder s, char c) {
        int n = s.length();
        return solve(s,0,c);
    }
    
    String solve(StringBuilder s,int i,char c){
        if (i == s.length()) {
            return s.toString();
        } 
        if(s.charAt(i)==c){
            s.deleteCharAt(i);
            return solve(s,i,c);
        }
        
        else{
        return solve(s,i+1,c);}
        
        
    }
}