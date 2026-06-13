class Solution {
    public int maxNumberOfBalloons(String text) {
        Map <Character,Integer> need = new HashMap<>();
        Map <Character,Integer> have = new HashMap<>();;

        String target = "balloon";
        for(int i=0;i<target.length();i++){
            char c = target.charAt(i);
            need.put(c,need.getOrDefault(c,0)+1);
        }

        for(int i=0;i<text.length();i++){
            char c = text.charAt(i);
            have.put(c,have.getOrDefault(c,0)+1);
        }
        int ans = Integer.MAX_VALUE;
        for(Map.Entry <Character,Integer> e :  need.entrySet()){
            char character = e.getKey();
            int value = e.getValue();

            int counthave = have.getOrDefault(character,0);

            ans =Math.min(ans,counthave/value);
        }
        return ans;
    }
    
}