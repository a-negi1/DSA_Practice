/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
var removeDuplicates = function(s, k) {
    let st = [];
    

for(let i=0;i<s.length;i++){
     let c = s[i];

     if(st.length > 0 && st[st.length-1][0] === c){
           st[st.length-1][1]++
        
  }
   else{
     st.push([c,1]);
      
  }

  if(st.length>0 && st[st.length-1][1] === k){
      st.pop();
  }


}
let ans =""
     for(let i=0;i<st.length;i++){
         let ch=st[i][0];
         let cnt = st[i][1];

        for(let j=0;j<cnt;j++){
            ans+=ch;
        }
     }

     return ans;

    
};