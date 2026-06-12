class Solution {
    public int firstUniqChar(String s) {
        Map <Character,Integer> h = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            h.put(c,h.getOrDefault(c,0)+1);

            
        }

        for(int i=0;i<s.length();i++){
            if(h.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;

    }
}