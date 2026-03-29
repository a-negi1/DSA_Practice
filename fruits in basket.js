/**
 * @param {number[]} fruits
 * @return {number}
 */
var totalFruit = function(fruits) {
    let low = 0 ;
    let res = -Infinity;
    let map = new Map();
    for(let high=0;high<fruits.length;high++){
        map.set(fruits[high],(map.get(fruits[high])||0)+1);

        while(map.size>2){
            map.set(fruits[low],map.get(fruits[low])-1)
            if(map.get(fruits[low])===0){
                map.delete(fruits[low]);
            }
            
            low++;
        }
        if(map.size<=2){
                let sum = high - low +1;
                res = Math.max(sum,res);}

        
    }
    return res
};