import java.util.*;

class Solution {
    
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        
        // 1. 참가자 이름 개수 세시
        for(String name : participant){
            map.put(name, map.getOrDefault(name, 0) +1);
        }
    
        // 2. 완주자 이름 값 빼기
        for(String name : completion){
            map.put(name, map.get(name)-1);
        }
        
        // 3. 남아있는 이름 찾기
        for(String name : map.keySet()){
            if(map.get(name) > 0){
                answer = name;
                break;
            }
        }
        
        
        return answer;
    }
}