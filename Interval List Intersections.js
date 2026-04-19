/**
 * @param {number[][]} firstList
 * @param {number[][]} secondList
 * @return {number[][]}
 */
var intervalIntersection = function(firstList, secondList) {
    
    let res = []

    let i=0;
    let j=0
    
    while(i<firstList.length && j<secondList.length){
        let start1 = firstList[i][0];
        let end1 =  firstList[i][1];
        let start2=secondList[j][0];
        let end2=secondList[j][1];
        
            if(end1>=start2 && end2>=start1){
            let a = Math.max(start1,start2)
            let b=  Math.min(end1,end2)
            res.push([a,b])
            }

        
        if (end1<=end2){
            i++
        }
        else{
            j++;
        }
    }
    return res;
    
};