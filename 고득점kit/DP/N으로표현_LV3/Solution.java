package 고득점kit.DP.N으로표현_LV3;
import java.util.*;

class Solution {
    public int solution(int N, int number) {
        
        if (N == number) return 1;

        List<Set<Integer>> dp = new ArrayList<>();
        
        // 인덱스 맞추기용 더미 데이터
        dp.add(new HashSet<>());
        
        for(int i = 1; i <=8; i++){
            Set<Integer> current = new HashSet<>();
            
            // N,NN,NNN 만들기
            int temp = 0;
            for(int j = 0; j < i; j++){
                temp = temp * 10 + N;    
            }
            
            current.add(temp);
            
            for(int j = 1; j < i; j++){
                Set<Integer> set1 = dp.get(j);
                Set<Integer> set2 = dp.get(i-j);
                
                for(int a : set1){
                    for(int b : set2){
                        current.add(a + b);
                        current.add(a - b);
                        current.add(a * b);
                        if(b != 0){
                            current.add(a / b);
                        }
                    }
                }
            }
            
            if(current.contains(number)){
                return i;
            }
            dp.add(current);
            
        }
        
        return -1;
    }
}