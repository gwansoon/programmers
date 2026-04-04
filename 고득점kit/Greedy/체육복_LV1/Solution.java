import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        boolean[] lostCheck = new boolean[n+1];
        boolean[] reserveCheck = new boolean[n+1];
        
        for(int i : lost){
            lostCheck[i] = true;
        }
        
        for(int i : reserve){
            reserveCheck[i] = true;
        }
        
        for(int i = 1; i <= n; i++){
            if(lostCheck[i] && reserveCheck[i]){
                lostCheck[i] = false;
                reserveCheck[i] = false;
            }
        }
        
        for(int i = 1; i <= n; i++){
            if(lostCheck[i] == false){
                answer++;
            }
        }
        
        for(int i = 1; i <= n; i++){
            if(lostCheck[i] == true){
                if(i > 1 && reserveCheck[i-1]){// 왼쪽 확인 
                    reserveCheck[i-1] = false;
                    answer++;
                }else if(i < n && reserveCheck[i + 1]){ // 오른쪽 확인
                    reserveCheck[i+1] = false;
                    answer++;
                }
            }
        }
        
        return answer;
    }
}