/**
 * @param {number[]} temperatures
 * @return {number[]}
 */
var dailyTemperatures = function(temperatures) {
    let st = [];
    let n = temperatures.length;
    let answer = new Array(n).fill(0)
    st.push(n-1);

    for(let i=n-2;i>=0;i--){
        while(st.length > 0 && temperatures[st[st.length -1]] <= temperatures[i] ){
            st.pop();}
            if(st.length===0){
                answer[i] = 0;
            }

            else{
                answer[i] = st[st.length-1]-i;
                
            }
            st.push(i);
        
    }
    return answer;
    
};