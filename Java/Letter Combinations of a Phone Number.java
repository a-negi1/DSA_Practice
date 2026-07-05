class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap <Character,String> h = new HashMap<>();
        h.put('2',"abc");
        h.put('3',"def");
        h.put('4',"ghi");
        h.put('5',"jkl");
        h.put('6',"mno");
        h.put('7',"pqrs");
       h.put('8',"tuv");
        h.put('9',"wxyz");

        ArrayList <String> res = new ArrayList<>();

        solve(digits,0,h,new StringBuilder(),res);
        return res;
    }

    void solve(String  d,int idx,HashMap<Character,String> m,StringBuilder sb,ArrayList <String> res){
        if(idx == d.length()){
            res.add(sb.toString());
            return;
        }

        String choice = m.get(d.charAt(idx));
        for(int i=0;i<choice.length();i++){
            sb.append(choice.charAt(i));
            solve(d,idx+1,m,sb,res);
            sb.deleteCharAt(sb.length()-1);


        }
        

    }
}