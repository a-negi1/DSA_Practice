/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var subarraysDivByK = function(nums, k) {
    let freq = new Map();
    let sum = 0;
    let res = 0 ;
    freq.set(0,1);
    for (let i = 0 ;i<nums.length;i++){
        sum += nums[i]
        rem =((sum%k)+k)%k;
        if (freq.has(rem)){
            res+=freq.get(rem);

        }

        freq.set(rem,(freq.get(rem)||0) + 1);
    }
    return res;
    
};