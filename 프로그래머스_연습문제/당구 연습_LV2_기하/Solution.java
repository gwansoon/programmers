class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        for(int i = 0; i < balls.length; i++){
            int x = balls[i][0]; // i 번째 적구 x값
            int y = balls[i][1]; // i 번째 적구 y값
            
            int min = Integer.MAX_VALUE; // 최대값 초기세팅

            // 위쪽으로 튕기는경우 
            if(!(startY < y && startX == x)){
                int dx = startX - x;
                int dy = startY - (2 * n - y);
                int result = (dx * dx + dy * dy);
                min = Math.min(min, result);
            }

            // 아래쪽으로 튕기는 경우
            if(!(startY > y && startX == x)){
                int dx = startX - x;
                int dy = startY - (-y);
                int result = (dx * dx + dy * dy);
                min = Math.min(min, result);
            }

            // 왼쪽으로 튕기는경우
            if(!(startX > x && startY == y)){
                int dx = startX - (-x);
                int dy = startY - y;
                int result = (dx * dx + dy * dy);
                min = Math.min(min, result);
            }


            // 오른쪽으로 튕기는경우
            if(!(startX < x && startY == y)){
                int dx = startX - (2 * m - x);
                int dy = startY - y;
                int result = (dx * dx + dy * dy);
                min = Math.min(min, result);
            }

            answer[i] = min;
        }
        return answer;
    }
}