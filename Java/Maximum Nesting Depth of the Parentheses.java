class Solution {
    public int maxDepth(String s) {
        Stack <Character> st = new Stack<>();

        int max = 0;

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(c =='('){
                
                st.push(c);
                max=Math.max(max,st.size());
            }
            else if(c==')'){
                st.pop();
            }
        }
        return max;
    }
}