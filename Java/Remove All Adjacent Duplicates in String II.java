import java.util.Stack;

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> st = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (!st.isEmpty() && st.peek()[0] == c) {
                st.peek()[1]++;
            } else {
                st.push(new int[]{c, 1});
            }
            
            if (!st.isEmpty() && st.peek()[1] == k) {
                st.pop();
            }
        }
        
        StringBuilder ans = new StringBuilder();
        
        for (int[] pair : st) {
            char ch = (char) pair[0];
            int cnt = pair[1];
            
            for (int j = 0; j < cnt; j++) {
                ans.append(ch);
            }
        }
        
        return ans.toString();
    }
}