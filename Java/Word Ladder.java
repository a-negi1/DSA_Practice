class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size() ;

       HashMap <String,Integer> map = new HashMap<>();

       for(int i=0;i<n;i++){
        map.put(wordList.get(i),0);
       }
       if(!map.containsKey(endWord)){
            return 0;
        }
        
        Queue <String> q = new LinkedList<>();
        q.offer(beginWord);
        map.put(beginWord,1);

        while(!q.isEmpty()){
         String currentWord = q.poll();
         
         int currentSteps = map.get(currentWord);
        
         if(currentWord.equals(endWord)){
            return currentSteps;
         }
           char wordChars [] = currentWord.toCharArray();
           for(int i=0;i<wordChars.length;i++ ){
            char originalChar = wordChars[i];
            
            for(char c = 'a';c<='z';c++){
                if( wordChars[i]==c){
                    continue;
                    }

                wordChars[i] = c;
                String newWord = String.valueOf(wordChars);
                
                if(map.containsKey(newWord) && map.get(newWord)==0){
                    q.offer(newWord);
                    map.put(newWord,currentSteps +1);
                    
                }


            }
            wordChars[i] = originalChar;
           }
        }
        return 0;
    }
}