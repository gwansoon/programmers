class Solution {
        static final int MOD = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] dp = new int[n+1][m+1];
        
        // 물웅덩이 표시
        boolean[][] water = new boolean[n+1][m+1];
        
        int water_len = puddles.length;
        

        for(int[] water_xy : puddles){
            int water_x = water_xy[0];
            int water_y = water_xy[1];

            water[water_y][water_x] = true;
        }
        
        
        // 집 세팅
        dp[1][1] = 1;
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                // 물웅덩이 체크
                if(water[i][j]){continue;}
                // 집 은 패스
                if(i == 1 && j == 1){continue;}
                
                // dp 채우기  왼쪽 값 + 위쪽 
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % MOD;
                
            }
        }
            
        return dp[n][m];
    }
}