class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxsum = 0;
        int max =0;
        int res = -1;
        for(int i=0;i<weights.length;i++){
            max=Math.max(max,weights[i]);
            maxsum += weights[i];
        }
        int low = max;
        int high =maxsum;

        while(low<=high){
            int guess = low + (high-low)/2;

            if(count(weights,days,guess) == true){
                res = guess;
                high = guess -1;
            }else{
                low = guess+1;
            }
        }
        return res;
    }

    boolean count (int []arr,int days,int guess){
        int k = 1;
        int prev = 0;
        for(int i=0;i<arr.length;i++){
            int sum = arr[i]+prev;

            if(sum>guess){
                k++;
                prev=arr[i];
            }
            else{
                prev=sum;
            }

            if(k>days){
                return false;
            }
        }
        return true;

    }
}