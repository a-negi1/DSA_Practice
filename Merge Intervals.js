/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
    if (intervals.length === 0) return [];

   
    intervals.sort((a, b) => a[0] - b[0]);

    let result = [];
    let [start1, end1] = intervals[0];

    for (let i = 1; i < intervals.length; i++) {
        let [start2, end2] = intervals[i];

        
        if (start2 <= end1) {
            end1 = Math.max(end1, end2);
        } else {
            result.push([start1, end1]);
            [start1, end1] = [start2, end2];
        }
    }

    
    result.push([start1, end1]);

    return result;
};