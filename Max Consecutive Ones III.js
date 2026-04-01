/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */


var longestOnes = function(nums, k) {
    let low =0 ;
    let res = -Infinity;
    let count=0 ;
    
        for(let high=0;high<nums.length;high++ ){
        if(nums[high] === 0 ){
            count++
        }

        
        while (count>k){
            if(nums[low] === 0 ){
            count--}
            low++
            }
        
        let len =high-low+1
        res = Math.max(res,len) ;
            
    }
    return res
};