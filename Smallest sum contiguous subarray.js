// User function Template for javascript
/**
 * @param {number[]} A
 * @param {number} N
 * @returns {number}
 */

class Solution {
    
    smallestSumSubarray(A, N) {
        let bestending = A[0];
        let ans = A[0]
        
        for(let i=1;i<N;i++){
            let v1 = A[i]
            let v2 = bestending + A[i]
            
            bestending = Math.min(v1,v2)
            ans = Math.min(ans,bestending)
        }
        return ans
        
    }
}