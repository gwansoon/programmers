import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Java_function_list {
    public void java_function_list{

        // List = 크기 자동 늘어나는 배열
        List<Integer> list = new ArrayList<>(); // 리스트 선언
        list.add(10); // 리스트 값 삽입
        list.get(inedx_num:); // 값 꺼내기
        list.size();    // 크기
        list.set(index_num:,element:); // 수정
        list.remove(index_num:); // 삭제

        Collections.sort(list); // 오름차순 정렬
        Collections.sort(list, Collections.reverseOrder()); // 내림차순정렬

        // 2차원 리스트
        List<int[]> list = new ArrayList<>(); // 배열을 저장하는 리스트 선언
        list.add(new int[]{3, 2, 1}); // 배열 삽입
        list.add(new int[]{5, 1, 2});
        
        // (a, b) → a랑 b를 비교해서 누가 앞으로 갈지 정하는 함수
        Collections.sort(list, (a, b) -> { 
            return b[0] - a[0]; // 내림차순
        });

        Collections.sort(list, (a,b)->{
            if(b[0] != a[0]) return b[0]-a[0]; // 비교 조건 1
            return b[1]-a[1]; // 비교조건 2
        });

    }
}
