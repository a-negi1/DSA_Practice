class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int low = 1;
        int n = stalls.length;
        int high = stalls[n-1] - stalls[0];
        int res = -1;
        
        
        while(low<=high){
            int guess = low + (high-low)/2;
            
            if(cal(stalls, k,guess) == true){
                res = guess;
                low = guess +1;
            }
            else{
                high = guess -1;
            }
            
        }
        return res;
        
    }
    boolean cal(int [] stalls,int k , int guess){
        
        int cow = 1;
        int pos = stalls[0];
        
        for(int i =0;i<stalls.length;i++){
            int dis = stalls[i]-pos;
            
            if(dis>=guess){
                cow++;
                pos = stalls[i];
            }
            
            if(cow == k){
                return true;
            }
        }
        return false;
    }
}