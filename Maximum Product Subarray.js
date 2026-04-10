var maxProduct = function(nums) {
    let ans = nums[0];
    let bestMin = nums[0];
    let bestMax = nums[0];

    for (let i = 1; i < nums.length; i++) {
        let v1 = nums[i];
        let v2 = bestMax * nums[i];
        let v3 = bestMin * nums[i];

        bestMax = Math.max(v1, v2, v3);
        bestMin = Math.min(v1, v2, v3);

        ans = Math.max(ans, bestMax);
    }

    return ans;
};