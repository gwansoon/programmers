import java.util.Arrays;

class Solution {
    public int solution(int[][] info, int n, int m) {

        // dp[a] = A가 흔적이 a일 때 가능한 최소 B의 흔적 생성
        int[] dp = new int[n];

        // 초기값을 매우 큰 값으로 설정
        // 아직 만들 수 없는 상태라는 의미
        Arrays.fill(dp, Integer.MAX_VALUE);

        // 아무 물건도 훔치지 않았을 때
        // A 흔적 = 0
        // B 흔적 = 0
        dp[0] = 0;

        // 모든 물건을 하나씩 처리
        for(int i = 0; i < info.length; i++){

            int aTrace = info[i][0]; // A가 훔칠 때의 흔적
            int bTrace = info[i][1]; // B가 훔칠 때의 흔적

            // 다음 상태를 저장할 배열
            int[] next = new int[n];
            Arrays.fill(next, Integer.MAX_VALUE);

            // 현재 가능한 모든 A 흔적 상태 확인
            for(int a = 0; a < n; a++){
                
                // 현재 상태가 불가능한 경우 건너뜀
                if(dp[a] == Integer.MAX_VALUE)
                    continue;

                int newA = a + aTrace; // A가 이 물건을 훔쳤을 때의 새로운 흔적

                if(newA < n){

                    // B 흔적은 그대로
                    int newB = dp[a];
                    
                    // 더 작은 B 흔적을 저장
                    next[newA] = Math.min(next[newA], newB);
                }

                // ---------------------------
                // 경우 2 : B가 이 물건을 훔친다
                // ---------------------------

                int newB = dp[a] + bTrace;

                // 경찰에 잡히지 않는 경우만
                if(newB < m){

                    // A 흔적은 그대로
                    next[a] = Math.min(next[a], newB);
                }                
            }

            // 다음 상태를 현재 상태로 교체
            dp = next;
        }

        // 모든 물건을 처리한 후
        // 가능한 A 흔적 중 가장 작은 값 찾기
        for(int a = 0; a < n; a++){
            if(dp[a] < m)
                return a;
        }
        // 불가능한 경우
        return -1;
    }
}
