class Solution {
    public int longestPalindrome(String s) {
        Map <Character,Integer> m = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            m.put(c,m.getOrDefault(c,0)+1);
        }
        
        int res=0; 
        boolean odd = false;
        for(Map.Entry <Character,Integer> a : m.entrySet()){
            if(a.getValue() % 2 == 0){
                res+=a.getValue();
            }
            else{
                res+=a.getValue()-1;
                odd=true;
            }
        }
        if (odd) {
            res+=1;
        }

        return res;
    }
}