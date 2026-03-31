/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
let find =(a)=>{
    let maxc = -1;
    for(let i=0;i<256;i++){
        maxc = Math.max(a[i],maxc);
    }
    return maxc;
}
var characterReplacement = function(s, k) {
    let low = 0 ;
    let f = new Array(256).fill(0);
    
    let res = -Infinity
    
    for(let high=0;high<s.length;high++){
        f[s.charCodeAt(high)]++; 
        let len = high - low +1
        
        let freq =find (f)
        let diff = len - freq 
        while(diff>k){
            f[s.charCodeAt(low)] -- ;
            low++
             len = high - low +1    
             freq = find (f)
             diff = len - freq 

            
        }

         len = high - low +1
        res = Math.max(res,len);
    }
    return res
    
};