package 고득점kit.해시.폰켓몬_LV1;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // N마리의 포켓몬중 N/2마리를 가져가도 좋다고 했습니다.
        int maxPick = nums.length / 2;
        
        Set<Integer> set = new HashSet<>();
        
        for(int n : nums){
            set.add(n);    
        }
        
        int answer = Math.min(maxPick, set.size());
        return answer;
    }
}