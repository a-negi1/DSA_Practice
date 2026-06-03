/**
 * @param {string} s
 * @return {string}
 */
var removeDuplicates = function(s) {
    let arr = [];

    for(let i=0;i<s.length;i++){
        let a = s[i];

        if(arr.length >0 && a === arr[arr.length-1]){
            arr.pop();
        }
        else{
            arr.push(a);
        }
    }

    let an = "";
    for(let i=0;i<arr.length;i++){
        an+=arr[i]
    }
    return an
    
    
};