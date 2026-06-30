class Pair{
    String first;
    int second;

    Pair(String a,int b){
        this.first=a;
        this.second=b;
    }
}
class Solution {
    public String reorganizeString(String s) {
        
        HashMap <Character,Integer> h = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->
            b.second - a.second);

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            h.put(ch,h.getOrDefault(ch,0)+1); 
        }

        for(Map.Entry<Character,Integer> en : h.entrySet()){
            pq.add(new Pair(String.valueOf(en.getKey()),en.getValue()));
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;

        while(!pq.isEmpty()){
            Pair p1 = pq.poll();

            if(index==0||sb.charAt(index-1) != p1.first.charAt(0)){
                sb.append(p1.first);
                index++;
                p1.second --;

                if(p1.second>0){
                    pq.add(p1);
                }
            }
            else{
                if(pq.isEmpty()){
                    return "";
                }
                Pair p2 = pq.poll();
                sb.append(p2.first);
                p2.second --;
                index++;
                if(p2.second>0){
                    pq.add(p2);
                }
                pq.add(p1);
            }
        }
        return sb.toString();
    }
}