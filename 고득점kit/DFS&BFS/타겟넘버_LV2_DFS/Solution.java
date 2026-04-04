class Solution {
    
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
    
    private void dfs(int[] numbers, int target, int idx, int count){
        
        if(idx == numbers.length){
            if(count == target){
                answer++;
            }
            return;
        }
        
        dfs(numbers, target, idx+1 , count + numbers[idx]);
        dfs(numbers, target, idx+1,  count - numbers[idx]);
    }
        
}