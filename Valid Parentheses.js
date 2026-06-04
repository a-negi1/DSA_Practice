/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    let arr = [];

        for(let i=0;i<s.length;i++){
            let ch = s[i]
            if(ch == '(' || ch == '{' || ch== '['){
                arr.push(ch)
            }
            else {
                if(arr.length === 0){
                    return false;
                }
                
                if(ch == ')' && arr[arr.length-1] =="(" || ch == '}' && arr[arr.length-1] =="{" || ch == ']' && arr[arr.length-1] =="["){
                arr.pop()
                return true;
            }
            
            else {
                return false;
            }
        }
        }
        return arr.length ===0;
};