class Pair{
    int first;
    int second;

    Pair(int a,int b){
        this.first = a;
        this.second = b;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap <Integer,Integer> h = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            h.put(nums[i],h.getOrDefault(nums[i],0)+1);
        }
        

        PriorityQueue <Pair> p = new PriorityQueue<>((a,b) ->  a.second - b.second );

        for(Map.Entry<Integer,Integer> m : h.entrySet()){
            p.add(new Pair(m.getKey(),m.getValue()));
            if(p.size() > k){
            p.poll();
        }
        }

        int [] ans = new int[k];
        
        for(int i=0;i<k;i++){
            ans[i]= p.poll().first;
            
        }

        return ans;
    }
}