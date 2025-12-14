class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        return binary_search(diffs, times, limit);
    }
    
    public int binary_search(int[] diffs, int[] times, long limit){
        int min = 1; // 최소레벨
        int max = 100000; // 최대레벨
        
        
        while(min < max){
            int level = (min + max) / 2;
            long play_time = playing(diffs, times, level);
                
            // 시간 초과
            if(play_time > limit){
                min = level+1;
            }else{
                max = level;
            }
        }
        return max;
    }
    
    public long playing(int[] diffs, int[] times, int level){
        long play_time = 0;
        play_time += (long)times[0];
        
        for(int i = 1; i < diffs.length; i++){
            if(diffs[i] <= level){
                play_time += (long)times[i];
            }else{
                play_time += (long)(((times[i] + times[i-1]) * (diffs[i] - level)) + times[i]);
            }
        }
        return play_time;
    }
}









