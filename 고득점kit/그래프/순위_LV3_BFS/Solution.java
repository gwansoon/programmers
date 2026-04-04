import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        
        List<Integer>[] winGraph = new ArrayList[n + 1];
        List<Integer>[] loseGraph = new ArrayList[n + 1];
        
        for(int i = 1; i <=n; i++){
            winGraph[i] = new ArrayList<>();
            loseGraph[i] = new ArrayList<>();
        }
        
        for(int[] result : results){
            int win = result[0];
            int lose = result[1];
            
            winGraph[win].add(lose);
            loseGraph[lose].add(win);
        }
    
        int answer = 0;
        
        for(int i = 1; i <= n; i++){
            int winnCount = bfs(i, winGraph, n);
            int loseCount = bfs(i, loseGraph, n);
            
            if((winnCount + loseCount) == n-1){
                answer++;
            }
        }
        
        
        return answer;
    }
    
    private int bfs(int i, List<Integer>[] Graph, int n){
        boolean[] visit = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(i);
        visit[i] = true;
        
        int count = 0;
            
        while(!(queue.isEmpty())){
            int now = queue.poll();
            
            for(int next : Graph[now]){
                if(visit[next] == false){
                    visit[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }
        return count;   
    }
}