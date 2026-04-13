/**
 * @param {number[]} arr
 * @return {number}
 */
var maximumSum = function(arr) {
    let nodelete =arr[0];
    let onedelete =0

    let res=arr[0] 

    for(let i = 1;i<arr.length;i++){
    let prevnodelete = nodelete 
    
    
    nodelete = Math.max(nodelete+arr[i],arr[i]);
    onedelete = Math.max(prevnodelete,onedelete+arr[i])

    res = Math.max(res,nodelete,onedelete)}
    return res;
};