/**
 * @param {number[][]} intervals
 * @param {number[]} newInterval
 * @return {number[][]}
 */
var insert = function(intervals, newInterval) {
    let res = []
    let res2 = []
    let insert = false;

    for(let i=0;i<intervals.length;i++){
        let start =  intervals[i][0]

        if(start >= newInterval[0] && insert === false){
            res.push(newInterval);
            insert =true;
        }

        res.push(intervals[i])
        

    }
    if (insert === false){
        res.push(newInterval)
    }

    let start1 = res[0][0]
    let end1 = res[0][1]

    for(let i=0;i<res.length;i++){
        let start2 = res[i][0];
        let end2 = res[i][1];

        if (end1>=start2 ){
            end1 = Math.max(end1,end2)
            
        }else{
            res2.push([start1,end1]);
            start1 = start2
            end1 = end2;

            
        }
        

    }
    res2.push([start1,end1]);

    return res2;

};