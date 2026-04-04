import java.util.*;

class Solution {
    
    // 상, 하, 좌, 우
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        
        int n = maps.length; 
        int m = maps[0].length; 
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];
        
        // 현재 내 말 위치
        queue.add(new int[]{0,0,1});
        // 정복 위치
        visit[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] bag = queue.poll();
            int x = bag[0];
            int y = bag[1];
            int count = bag[2];
            
            // 1. 도달 했냐? 
            if(x == n - 1 && y == m - 1 ){
                return count;    
            }
            
            // 2. 안했으면 이동해봐 4방향
            for(int i = 0; i < 4; i++){
                int mx = x + dx[i];
                int my = y + dy[i];
                
                //      2-1 벗어났냐? 
                if(mx < 0 || my < 0 || mx >= n || my >= m){
                    continue;
                }
                //      2-2 벽이냐?
                if(maps[mx][my] == 0){
                    continue;
                }
                //      2-3 이미 왔다갔냐? 
                if(visit[mx][my] == true){
                    continue;
                }
                //      신규개척 추가 후 다시 ㄱㄱ 
                visit[mx][my] = true;
                queue.add(new int[]{mx,my,count+1});
            
            }
            
            
        }
         
        return -1;
        
    }
}