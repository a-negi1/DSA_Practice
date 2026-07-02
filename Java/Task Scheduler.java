class Pair{
    int frequency;
    char s ;
    public Pair(int frequency, char s) {
        this.frequency = frequency;
        this.s = s;
}
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
       
        HashMap <Character,Integer> freq = new HashMap<>();
        HashMap <Character,Integer> curr = new HashMap<>();
        
        PriorityQueue <Pair> pq = new PriorityQueue<>((a,b)-> b.frequency - a.frequency);

        for(int i=0;i<tasks.length;i++){
            
            char c = tasks[i];
            curr.put(c,1);
            freq.put(c,freq.getOrDefault(c,0)+1);
        }

        for(Map.Entry <Character,Integer> e: freq.entrySet()){
            pq.add(new Pair(e.getValue(),e.getKey()));
        }

        int seat =1;
        while (!pq.isEmpty()) {
            ArrayList<Pair> pulled = new ArrayList<>();
            
            while (!pq.isEmpty()) {
                Pair p = pq.poll();
                int fr = p.frequency;
                char c = p.s;

                if (curr.get(c) <= seat) {
                   
                    if (fr > 1) {
                        pq.add(new Pair(fr - 1, c));
                        curr.put(c, seat + n + 1);
                    }
                    
                    break; 
                } else {
                   
                    pulled.add(p);
                }
            }

           
            for (int i = 0; i < pulled.size(); i++) {
                pq.add(pulled.get(i));
            }

           
            seat++;
        }
        return seat -1;
    }
}