import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        boolean answer = true;
        
        Set<String> ph_set = new HashSet<>();
        
        for(String phnum : phone_book){
            ph_set.add(phnum);
        }
        
        for(String phnum : ph_set){
            for(int i = 1; i < phnum.length(); i++){
                String sub = phnum.substring(0,i);
                if(ph_set.contains(sub)){
                    return false;
                }
            }
        }
        
        
        return answer;
    }
}