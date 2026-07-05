class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        solve(n,0,0,new StringBuilder(),res);
        return res ;
    }

    void solve(int n,int open,int close,StringBuilder sb,ArrayList <String> res){
        if(sb.length() == 2*n){
            res.add(sb.toString());
            return ;
        }

        if(open<n){
            sb.append("(");
            solve(n,open+1,close,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close<open ){
            sb.append(")");
            solve(n,open,close+1,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}