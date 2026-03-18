package 프로그래머스_연습문제.광물캐기_LV2_그리디;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int[] picks, String[] minerals) {
    
        // 전체 곡괭이 수
        int totalPick = picks[0] + picks[1] + picks[2];

        // 실제 캘 수 있는 최대 광물 수
        int maxMinerals = totalPick * 5;

        // minerals 5개씩 묶기  -> 배열로 저장
        List<int[]> minerals_5_list = new ArrayList<>();
        
        int diamond = 0;
        int iron = 0;
        int stone = 0;

        for(int i = 0; i < minerals.length && i <maxMinerals; i++){
            
            switch (minerals[i]) {
                case "diamond":
                    diamond++;
                    break;
                case "iron":
                    iron++;
                    break;
                case "stone":
                    stone++;
                    break;
            }

            if(i % 5 == 4){
                minerals_5_list.add(new int[] {diamond,iron,stone});
                diamond = 0;
                iron = 0;
                stone=0;
            }
            if(i == minerals.length - 1 ){
                minerals_5_list.add(new int[] {diamond,iron,stone});        
            }
        }

        // 저장된 배열 정렬
        Collections.sort(minerals_5_list, (a,b) -> {
            if(b[0] != a[0]) return b[0] - a[0]; // diamond
            if(b[1] != a[1]) return b[1] - a[1]; // iron
            return b[2] - a[2]; // stone
        });
        
        int answer = 0;
        int mineral_pack_count = 0;

        // 다이아몬드 곡괭이부터 순차적으로 사용
        for(int j = 0; j < picks.length; j++){ // diamond, iron , stone 
            
            // 각 곡괭이가 있고 , 광물 팩을 다확인 안했을 경우
            while(picks[j] > 0 && mineral_pack_count < minerals_5_list.size()){
                int[] mineral_pack = minerals_5_list.get(mineral_pack_count);
                
                if(j == 0){
                    answer += (mineral_pack[0] * 1) + (mineral_pack[1] * 1) + (mineral_pack[2] * 1);       
                }else if(j == 1){
                    answer += (mineral_pack[0] * 5) + (mineral_pack[1] * 1) + (mineral_pack[2] * 1);       
                }else if(j == 2){
                    answer += (mineral_pack[0] * 25) + (mineral_pack[1] * 5) + (mineral_pack[2] * 1);       
                }
                
                picks[j]--;
                mineral_pack_count++;
            }
        }
        
        return answer;

    }
}