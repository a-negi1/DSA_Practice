/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubarraySumCircular = function(nums) {
    
    let maxend =nums[0]
    let minend = nums[0]
    let  maxres =nums[0] ;
    let minres = nums[0];
    let count=nums[0]                                   
    for(let i=1;i<nums.length;i++){
        count += nums[i]
        let v1 =maxend + nums[i];
        
        let v3 = nums[i]
        maxend = Math.max(v1,v3)
        maxres = Math.max(maxres,maxend)

        let v2 = minend+nums[i];
        minend = Math.min(v2,v3);
        minres = Math.min(minres,minend);

        
       
    }
    if (maxres < 0) return maxres;
    return Math.max(maxres,count - minres)
        
};