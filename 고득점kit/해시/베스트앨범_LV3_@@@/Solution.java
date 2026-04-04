import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        
        // 1. 장르 별 재생 총 카운트
        
        HashMap<String, List<int[]>> groupMap = new HashMap<>();
        HashMap<String, Integer> countRank = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            
            if(!(groupMap.containsKey(genres[i]))){
                groupMap.put(genres[i], new ArrayList<>());
            }
            groupMap.get(genres[i]).add(new int[]{i,plays[i]});
            countRank.put(genres[i], countRank.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> genreName = new ArrayList<>(countRank.keySet());
        genreName.sort((a,b) -> countRank.get(b) - countRank.get(a));
        
    
        List<Integer> result = new ArrayList<>();
        
        for(String name : genreName){
            List<int[]> songs = groupMap.get(name);
            
            songs.sort((a,b) -> {
                if(b[1] == a[1]) return a[0] - b[0];
                return b[1] - a[1];
            });
            
            result.add(songs.get(0)[0]);
            
            if(songs.size() > 1){
                result.add(songs.get(1)[0]);
            }
        }
        
        int[] answer = new int[result.size()];
        
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}