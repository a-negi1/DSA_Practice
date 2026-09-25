class Solution {
    public String frequencySort(String s) {
        
        HashMap <Character,Integer> m = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char a=s.charAt(i);
            m.put(a,m.getOrDefault(a,0)+1);
        }

        Queue <Character> q = new PriorityQueue<>((a,b)->m.get(b)-m.get(a));
        q.addAll(m.keySet());

        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()){
            char c = q.poll();
            int freq = m.get(c);
        for(int i=0;i<freq;i++){
            sb.append(c);
        }
        }
        return sb.toString();
    }
    
}