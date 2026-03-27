/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var threeSumClosest = function(nums, target) {
    
    let a = nums.slice().sort((a,b)=>a-b);

    let result= Infinity;
    
    for(let i=0;i<a.length-2;i++){
        if(i>0 && a[i]===a[i-1]){continue;}
            let j=i+1;
        let k=a.length-1;
        
        while (j<k){
            let sum = a[i] + a[j] + a[k];
        if(Math.abs(target-sum)<Math.abs(target-result)){
            result = sum
            
            

        }
        if(sum<target){
            j++;
        }else if (sum>target){
            k--;

        }
        else{
            return sum;
        }
    }
    }
    return result

};