/**
 * @param {string} s
 * @param {number} k
 * @returns {number}
 */
class Solution {
    longestKSubstr(s, k) {
        let map = new Map()
        let res = -Infinity;
        let low = 0;
        
        for (let high = 0;high<s.length;high++){
            map.set(s[high],(map.get(s[high])||0)+1)
            
            while (map.size >k){
                map.set(s[low],map.get(s[low])-1)
                if(map.get(s[low]) === 0){
                    map.delete(s[low])
                }
                
                
            low ++;
            }
            if(map.size=== k ){
                    let sum = high - low +1;
                    res = Math.max(sum,res);
                }
            
             
    }
    return res=== -Infinity  ? -1 : res 
    
}
}