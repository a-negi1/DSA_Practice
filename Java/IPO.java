class Pair{
    int first;
    int second;

    Pair(int a,int b){
        this.first = a;
        this.second =b;
    }
}
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        ArrayList <Pair> arr= new ArrayList<>();
        for(int i=0;i<profits.length;i++){
            arr.add(new Pair(capital[i],profits[i]));
        }
        Collections.sort(arr,(p1,p2) ->p1.first - p2.first);
        PriorityQueue <Pair> pq = new PriorityQueue<>((a,b) -> b.second - a.second);

        int idx = 0;
        while(k-->0){
            while(idx< arr.size()){
                if(arr.get(idx).first>w){
                    break;
                }
                pq.add(arr.get(idx));
                idx++;
            }

            if(pq.isEmpty()){
                return w;
            }

            w= w + pq.poll().second;
            
        }

        return w;
    }
}