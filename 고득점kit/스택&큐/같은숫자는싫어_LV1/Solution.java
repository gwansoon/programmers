import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        List<Integer> call_list = new ArrayList<>();
        
        call_list.add(arr[0]);
        
        for(int i = 1; i < arr.length; i++){
            if(arr[i] != arr[i-1]){
                call_list.add(arr[i]);
            }
        }
        
        int[] answer = new int[call_list.size()];
        
        for(int i = 0; i < call_list.size(); i++){
            answer[i] = call_list.get(i);
        }

        return answer;
    }
}