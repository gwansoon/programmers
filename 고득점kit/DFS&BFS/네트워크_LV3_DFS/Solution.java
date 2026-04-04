class Solution {
    public int solution(int n, int[][] computers) {
        
        // n = 컴퓨터의 개수
        // compuers = 연결에 대한 정보
        int answer = 0;
        
        boolean[] sta = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(!sta[i]){
                dfs(i, computers, sta);
                answer++;
            }
        }
        return answer;
    }
    
    private void dfs(int now, int[][] computers, boolean[] sta){
        sta[now] = true;
        
        for(int j = 0; j < computers.length; j++){
            if(computers[now][j] == 1 && sta[j] == false){ // computers[now][j] == 1 인접해있고 && 아직 방문하지 않은 경우 
                dfs(j, computers, sta);                     // 가서 방문으로 바꿔라 
            }
        }
    }
}