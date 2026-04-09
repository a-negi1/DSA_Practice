var maxSubArray = function(nums) {
    let bestending = nums[0];
    let ans = nums[0];

    for (let i = 1; i < nums.length; i++) {
        let v1 = bestending + nums[i];
        let v2 = nums[i];

        bestending = Math.max(v1, v2);
        ans = Math.max(ans, bestending);
    }

    return ans;
};