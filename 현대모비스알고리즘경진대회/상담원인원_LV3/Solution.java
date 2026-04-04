import java.util.*;

class Solution {
    
    int answer = Integer.MAX_VALUE; // 기다린시간의 합 . 최대값 초기화
    List<int[]>[] typeReqs;
    
    public int solution(int k, int n, int[][] reqs) {
        
        // 1~ k = 상담 유형 수
        // n = 멘토 수
        // 각 멘토는 k개의 상담 유형중 하나만 담당 할 수 있다.
        // reqs [시각, 상담시간, 상담 유형]
        
        // 1. 상담 유형별로 데이터 분류
        typeReqs = new ArrayList[k+1]; // 상담 유형수 k 개 만큼 배낭 리스트 생성 // ex k가 3이면 3+1 = 4칸 0,1,2,3 -> 편의상 0은 버리고사용
        for(int i = 1; i <= k; i++){
            typeReqs[i] = new ArrayList<>(); // 1, 2 ...k 유형 // 인덱스에 리스트 생성
            // index:   0        1               2            3
            //         null   ArrayList[]   ArrayList[]   ArrayList[]
        }
        
        for(int[] req : reqs){
            // index 0      1       2
            // reqs [시각, 상담시간, 상담유형]
            int start_time = req[0];
            int running_time = req[1];
            int type = req[2];
            
            typeReqs[type].add(new int[]{start_time, running_time});
        }
        
        // 2. 각 유형별 최소 한명 씩 배정
        int[] mentors = new int[k+1];
        Arrays.fill(mentors, 1);
        
        // 3. 남은 멘토들 DFS로 분해
        int remain = n - k; // 총 멘토수에서 각유형 한명씩 빼기
        dfs(1, k, remain, mentors);
        
        return answer;
    }
    
    private void dfs(int idx, int k, int remain, int[] mentors){
        // 모든 유형 배정 완료
        if(idx == k + 1){ // 마지막 +1
            if(remain == 0){ // 모두 배정완료
                answer = Math.min(answer, calculateTotalWait(k, mentors));
            }
            return;
        }
        
        // 현재 유형에 추가로 0명 ~ remain명 배정해보기
        for(int add = 0; add <= remain; add++){
            mentors[idx] += add;
            dfs(idx + 1, k, remain - add, mentors);
            mentors[idx] -= add;
        }
    }
    
    // 현재 멘토 배치에서 전체 대기시간 계산
    private int calculateTotalWait(int k, int[] mentors){
        int totalWait = 0;

        for (int type = 1; type <= k; type++) {
            totalWait += calculateTypeWait(typeReqs[type], mentors[type]);
        }

        return totalWait;
    }
    
    // 한 상담 유형에 대한 총 대기시간 계산
    private int calculateTypeWait(List<int[]> typeReqs, int mentors){
        if (typeReqs.isEmpty()) return 0;
        
        // 각 멘토가 언제 상담이 끝나는지 저장
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int waitSum = 0;
        
        for(int[] req : typeReqs){
            int start_time = req[0];
            int runing_time = req[1];
            
            // 놀고있는 멘토가 있으면 바로 상담시작
            if(pq.size() < mentors){
                pq.offer(start_time+ runing_time); // ex) 시작 5분 상담시간 55 = 60 에 다음타자 오게끔
            }else{ // 꽉찼을경우 
                int next_end = pq.poll(); // 자리 하나 비우고
                
                if(next_end <= start_time){ // 최근 끝난시간이 다음 스타트 시간이랑 같으면 배로 상담 시작
                    pq.offer(start_time+ runing_time);
                }else{ // 기다린다면 그 기다린만큼 저장 후 시작
                    waitSum += next_end - start_time; 
                    pq.offer(next_end + runing_time);
                }
            }
        }
        return waitSum;
    }
}