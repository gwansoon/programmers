class Solution {
    public int solution(int[] players, int m, int k) {

        // 총 서버 증설 횟수
        int answer = 0;

        // 현재 운영 중인 서버 수
        int now_server = 0;

        // 서버가 종료되는 시간을 기록하는 배열
        // 예: expire[10] = 2 -> 10시에 서버 2대 반납 23시 증설시대시 
        int[] expire = new int[24 + k + 1];

        // 0시 ~ 23시까지 시뮬레이션
        for (int i = 0; i < players.length; i++) {

            // 현재 시간에 반납되는 서버 제거
            now_server -= expire[i];

            // 현재 시간에 필요한 서버 수 계산
            int need_server = players[i] / m;

            // 현재 서버 수가 부족하면 필요한 만큼 증설
            if (now_server < need_server) {

                int add = need_server - now_server;

                // 증설 횟수 증가
                answer += add;

                // 현재 운영 서버 증가
                now_server += add;

                // k시간 뒤 서버 반납 예약
                expire[i + k] += add;
            }
        }

        return answer;
    }
}