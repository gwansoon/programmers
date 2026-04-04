import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        List<Integer>[] graph = new ArrayList[n+1]; // 배열선언
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>(); // 리스트선언
        }
        
        for(int[]e : edge){
            int a = e[0];
            int b = e[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        // 거리배열 
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        
        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); // 1번 노드 시작
        dist[1] = 0;
        
        while(!(queue.isEmpty())){
            int now = queue.poll();
            
            for(int next : graph[now]){
                if(dist[next] == -1){
                    dist[next] = dist[now] + 1;
                    queue.add(next);
                }
            }
        }
        
        int longNode = 0;
        for(int i =1 ; i<= n; i++){
           longNode = Math.max(longNode, dist[i]); 
        }
        
        int answer = 0;
        for(int i = 1; i <= n; i++){
            if(longNode == dist[i]){
                answer++;
            }
        }
        
        
        return answer;
    }
}