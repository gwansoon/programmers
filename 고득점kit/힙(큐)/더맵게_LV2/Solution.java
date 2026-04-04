import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i : scoville){
            pq.add(i);
        }
        
        while(pq.size() > 1 && pq.peek() < K ){
            
            int min1 = pq.poll();
            int min2 = pq.poll();
    
            int scobil = min1 + (min2*2);
            pq.add(scobil);
            answer++;
        }       
        
        if(pq.size() == 1 && pq.peek() < K){
            answer = -1;
        }
        return answer;
    }
}