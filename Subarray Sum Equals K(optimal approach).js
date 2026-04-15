/**
 * @param {number[]} a
 * @param {number} k
 * @return {number}
 */
var subarraySum = function(a, k) {
    let sum = 0;
    let res = 0;

    // Map to store prefix sum frequency
    let freq = new Map();
    freq.set(0, 1);

    for (let i = 0; i < a.length; i++) {
        sum += a[i];

        let ques = sum - k;

        if (freq.has(ques)) {
            res += freq.get(ques);
        }

        // update frequency of current sum
        freq.set(sum, (freq.get(sum) || 0) + 1);
    }

    return res;
};