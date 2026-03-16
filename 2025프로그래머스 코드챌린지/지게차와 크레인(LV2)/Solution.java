class Solution {
    int answer = 0;

    public int solution(int n, int[][] q, int[] ans) {
        // n = 최대값
        // q = 입력한 정수를 담은 2차원 정수 배열
        // ans = 응답을 담은 1차원 정수배열
        
        // 현재 만들고 있는 비밀 코드 후보 5개를 저장할 배열
        int[] selected = new int[5];

        // 조합 만들기
        comb(1, 0, n, q, ans, selected);

        return answer;
    }

    // start : 이번에 선택을 시작할 숫자
    // depth : 지금까지 몇 개를 뽑았는지
    void comb(int start, int depth, int n, int[][] q, int[] ans, int[] selected){
        
        // 숫자 5개를 다 뽑았을 경우
        if(depth == 5){
            
            // 이 조합이 모든 질문 조건을 만족하는지 검사
            if(isPossible(q, ans, selected)){
                answer++;
            }
            return;
        }
        // 재귀함수
        for(int i = start; i <= n; i++){
            selected[depth] = i;    // 현재 위치에 숫자 저장
            comb(i + 1, depth + 1, n ,q,ans,selected);  // 다음 숫자 선택
        }
    }

    boolean isPossible(int[][] q, int[] ans, int[] selected){
        
        // 모든 질문에 대해 검사
        for(int i = 0; i < q.length; i++){
            int count = 0;  // 현재 질문과 겹치는 숫자 개수

            // q[i]의 5개 숫자와 selected의 5개 숫자를 비교
            for(int j =0; j < 5; j++){
                for(int k = 0; k < 5; k++){
                    if(q[i][j] == selected[k]){
                        count++;
                    }
                }
            }
            // 문제에서 알려준 정답 개수와 다르면 이 조합은 불가능
            if(count != ans[i]){
                return false;
            }
        }
        // 모든 질문을 통과하며 가능한 조합
        return true;
    }
}