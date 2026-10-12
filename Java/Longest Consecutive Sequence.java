class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet <Integer> h = new HashSet<>();
        if (nums == null||nums.length ==0){
            return 0;
        }
        for(int i=0;i<nums.length;i++){
            h.add(nums[i]);
        }

        int maxlen = 0;

        Iterator<Integer> iterator = h.iterator();
        while(iterator.hasNext()){
            int num = iterator.next();
            if(!h.contains(num-1)){
                int currentNum = num;
                int currentStreak = 1;

                while(h.contains(currentNum + 1)){
                currentNum +=1;
                currentStreak +=1;
            }

            maxlen = Math.max(maxlen,currentStreak);
                
            }

            
        }
        return  maxlen;
    }
}