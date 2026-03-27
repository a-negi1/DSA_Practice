<<<<<<< HEAD
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
    let i = 0 
    
    let a = nums.slice().sort((a,b)=>a-b)
    let ans = [];

    for(let i =0;i<nums.length-2;i++){
        if (a[i] === a[i - 1]){ continue};
            let j = i+1;
            let k = nums.length-1;
        while(j<k){
                if(a[i]+a[j]+a[k]=== 0 ){
                    ans.push([a[i],a[j],a[k]]);
                    j++;
                    k--;
                    while(j<k && a[j-1] === a[j]){j++};
                    while(j<k && a[k+1]===a[k]){k--};
                }
                else if(a[i]+a[j]+a[k]<0){
                    j++;
                }
                else{
                    k--;
                }
        }
        

        
    }
    return ans;
=======
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
    let i = 0 
    
    let a = nums.slice().sort((a,b)=>a-b)
    let ans = [];

    for(let i =0;i<nums.length-2;i++){
        if (a[i] === a[i - 1]){ continue};
            let j = i+1;
            let k = nums.length-1;
        while(j<k){
                if(a[i]+a[j]+a[k]=== 0 ){
                    ans.push([a[i],a[j],a[k]]);
                    j++;
                    k--;
                    while(j<k && a[j-1] === a[j]){j++};
                    while(j<k && a[k+1]===a[k]){k--};
                }
                else if(a[i]+a[j]+a[k]<0){
                    j++;
                }
                else{
                    k--;
                }
        }
        

        
    }
    return ans;
>>>>>>> aa9c967cb5ac5ca316bf5ff0e73e8952e69ac435
};