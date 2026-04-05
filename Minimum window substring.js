/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
function find(have,needed){
    for(let i = 0 ; i<256;i++){
            if(have[i]<needed[i]){
        return false;}

    }
    return true;


}
var minWindow = function(s, t) {
    let low = 0;
    let have = new Array(256).fill(0);
    let needed = new Array(256).fill(0);
    let res = Infinity;
    let start = 0;
    for (let i =0;i<t.length;i++){
        needed[t.charCodeAt(i)]++;
    }

    for(let high=0;high<s.length ;high++){
        have[s.charCodeAt(high)]++;
        while(find(have,needed)){
            let len = high - low +1
            if (res>len){
                res = len;
                start = low ;
            }
            have[s.charCodeAt(low)]--;
            low++;
        }
    }
    return res === Infinity? "": s.substr(start,res);

};