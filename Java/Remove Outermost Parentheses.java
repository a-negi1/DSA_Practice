class Solution {
    public String removeOuterParentheses(String s) {
        Stack <Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char a=s.charAt(i);

            if(a =='('){
                if(!st.isEmpty()){
                sb.append(a);
            }
                st.push(a);
            }
            else{
                st.pop();
                if(!st.isEmpty()){
                    sb.append(a);
                }
            }
            

        }
        return sb.toString();
        
    }
}