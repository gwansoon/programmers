import java.util.Arrays;

class Solution {

    static final int INF = 1_000_000_000;
    static final int OFFSET = 10;
    
    
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {

        // temperature = 실외 온도를 나타내는 정수
        // t1 ~ t2 : 실내 적정 온도
        // a = 희망온도 != 실내온다가 다를시 매분 전력 소모량
        // b = 희망온도 == 실내온다가 같을 시 매분 전력 소모량
        // onboard = 승객의 탑승정보 배열

        int n = onboard.length;
        int temp_len = (40 - (-10)) + 1;

        // 1. dp[분][온도] = 최소 소비전력 배열 만들기
        int[][] dp = new int[n][temp_len];

        // 2. 배열 최대값으로 초기화 (최솟값 찾는 문제기 때문에)
        for(int i = 0; i < n ; i++){
            Arrays.fill(dp[i], INF);
        }

        // 3. 0분일땐 초기 실외 온도로 초기화 
        dp[0][temperature + OFFSET] = 0;

        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j <= temp_len - 1; j++){

                if(dp[i][j] == INF)continue;
         
                // 4. 에어컨 끄는 경우 (비용 x)
                int nextTemp = j;
                if(j < temperature + OFFSET){
                    nextTemp = j+1; // 실외가 더 높은면 온도 1도 상승;
                }else if(j > temperature + OFFSET){
                    nextTemp = j-1; // 실외가 더 낮으면 온도 1도 하락
                }   

                // 기존값 보다 작은값일 때 갱신
                if(dp[i+1][nextTemp] > dp[i][j]){
                    dp[i+1][nextTemp] = dp[i][j];
                }

                // 5. 에어컨을 켜서 온도를 변화시키는 경우 (비용 a)
                if(j + 1 <= 50){
                    if(dp[i+1][j+1] > dp[i][j] + a){
                        dp[i+1][j+1] = dp[i][j] + a;
                    }
                }

                if(j - 1 >= 0){
                    if(dp[i+1][j-1] > dp[i][j] + a){
                        dp[i+1][j-1] = dp[i][j] + a;
                    }
                }

                // 6. 에어컨을 켜서 온도를 유지 시키는 경우 (비용 b)
                if(dp[i+1][j] > dp[i][j] + b){
                    dp[i+1][j] = dp[i][j] +  b;
                }
            }
            
            // 승객 탑승 시 조건 
            if(onboard[i+1] == 1){
                for(int k = 0; k <= 50; k++ ){
                    if(k < t1+OFFSET || k > t2+OFFSET){ // t1~t2 적정 범위 포함 안될시 값 버리기 
                        dp[i+1][k] = INF;
                    }
                }
            }
        }
        
        int answer = INF;

        // 최소 소비전력 찾기
        for(int z = 0; z <=50; z++){
            if(answer > dp[n-1][z]){
                answer = dp[n-1][z]; // 작은걸로 반환
            }
        }
        return answer;
    }
}