class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        
        int[][] dp = new int [n][n];
        
        // 시작점 
        dp[0][0] = triangle[0][0];
        
        // 1행부터 아래로 내려가면서 계산
        for(int i = 1; i < n ; i++){
            // 맨 왼쪽
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            
            // 가운데 부분
            for(int j = 1; j < i; j++){
                dp[i][j] = Math.max(
                    dp[i-1][j-1], // 왼쪽 위
                    dp[i-1][j]) // 오른쪽 위
                    + triangle[i][j]; // 현재 값
            }
            
            // 맨 오른쪽
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
            
        }
        
        int answer = 0;
        for(int j = 0; j < n; j++){
            answer = Math.max(answer,dp[n-1][j]);
        }
        return answer;
    }
}