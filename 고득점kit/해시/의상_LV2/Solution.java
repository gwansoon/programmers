import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        int answer = 1;
        
        HashMap<String, Integer> has = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++){
            has.put(clothes[i][1], has.getOrDefault(clothes[i][1], 0) +1);
        }
        
        for(String name : has.keySet()){
            answer = answer * (has.get(name) +1);
        }
        

        return answer -1 ;
    }
}