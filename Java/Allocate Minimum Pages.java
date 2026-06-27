class Solution {
    public int findPages(int[] arr, int k) {
        
        if(arr.length<k) return -1;
        int max=0;
        int maxsum=0;
        for(int i=0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
            maxsum += arr[i] ;
        }
        int low=max;
        int high=maxsum;
        int res=-1;
        while(low <= high){
            int guess= low + (high-low)/2;
            
            
            
            if(count(arr,k,guess)==true){
                res = guess;
                high = guess - 1;
            }
            else{
                low = guess + 1;}
        }
        return res;
        
    }
     boolean count(int [] arr,int k,int guess){
         int c =1;
         int prev=arr[0];
         
          
         for(int i=1;i<arr.length;i++){
            int sum = arr[i]+prev;
             
             if(sum>guess){
                 c++;
                 prev= arr[i];
                
             }
             else{
                 prev = sum;
             }
             
             if(c>k){
                 return false;
             }
         }
         return true;
     }
}