import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        int n = words.length;
        int checkcount = 0;
        
        for(int i = 0; i < n; i++){
            if(target.equals(words[i])){
                checkcount++;
            }
        }
        
        if(checkcount==0){
                return 0;
        }
        
        Queue<String[]> queue = new LinkedList<>();
        boolean[] check = new boolean[n];
        
        queue.add(new String[]{begin, "0"});

        
        while(!queue.isEmpty()){
            String[] data = queue.poll();
            String keyword = data[0];
            int count = Integer.parseInt(data[1]);
            
            if(keyword.equals(target)){
                return count;
            }
            
            for(int i = 0; i < n; i++){
                if(check[i] == true){
                    continue;
                }
                
                if(compare(keyword, words[i])){
                    check[i] = true;        
                    queue.add(new String[]{words[i], String.valueOf(count+1)});
                    
                }
            }            
        }
        return 0;
    }
    
    private boolean compare(String keyword, String word){
        int a = 0;
        
        for(int i = 0; i < word.length(); i++){
            if(keyword.charAt(i) != word.charAt(i)){
                a++;
            }
        }
        
        return a == 1;
        
    }
}