/**
 * @param {number[]} arr
 * @param {number} k
 * @return {number}
 */

class Solution {
    maxSubarraySum(arr, k) {
        
        let windowsum = 0;
        for(let i=0;i<k;i++){
            windowsum += arr[i];
            
          
                
            }   
        let maxsum = windowsum;
        for (let i = k;i<arr.length;i++){
            
            windowsum= windowsum - arr[i-k] +arr[i]
            maxsum = Math.max(maxsum,windowsum)
        }
        
        return maxsum
    }
}
