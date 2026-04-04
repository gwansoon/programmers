package Tip;
import java.util.*;


        substring(n , n);

        // ########################################################################

        // List = 크기 자동 늘어나는 배열
        List<Integer> list = new ArrayList<>(); // 리스트 선언
        list.add(10); // 리스트 값 삽입
        list.get(inedx_num:); // 값 꺼내기 (값 삭제 안됌)
        list.size();    // 크기
        list.set(index_num:,element:); // 수정
        list.remove(index_num:); // 삭제

        Collections.sort(list); // 오름차순 정렬
        Collections.sort(list, Collections.reverseOrder()); // 내림차순정렬


        // 2차원 리스트
        List<int[]> list = new ArrayList<>(); // 배열을 저장하는 리스트 선언
        list.add(new int[]{3, 2, 1}); // 배열 삽입
        list.add(new int[]{5, 1, 2});
        
        // 2차원 리스트 선언와 생성 분리
        List<int[]>[] type_reqs;

        type_reqs = new.ArrayList[k+1]; // 상담 유형수 k 개 만큼 배낭 리스트 생성 // ex k가 3이면 3+1 = 4칸 0,1,2,3 -> 편의상 0은 버리고사용

        for(int i = 1; i <= k; i++){
            type_reqs[i] = new ArrayList<>(); // 1, 2 ...k 유형 // 인덱스에 리스트 생성
            // index:   0        1            2            3
            //         null   ArrayList   ArrayList   ArrayList
        }

        // (a, b) → a랑 b를 비교해서 누가 앞으로 갈지 정하는 함수
        Collections.sort(list, (a, b) -> { 
            return b[0] - a[0]; // 내림차순
        });

        Collections.sort(list, (a,b)->{
            if(b[0] != a[0]) return b[0]-a[0]; // 비교 조건 1
            return b[1]-a[1]; // 비교조건 2
        });
        
        //#############################################################
        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }



        //#############################################################
        int value1 = 0;
        int value2 = 0;
        int min = Integer.MAX_VALUE; // 최대값 초기세팅

        min = Math.min(value1, value2); // 가장 작은값반환


        //# Queue 큐 ##########################################################

        // 일반 큐
        Queue<int[]> queue = new LinkedList<>();
        queue.add();
        queue.poll(); // 꺼내기 제일 먼저 들어온 것부터 꺼냄 (FIFO)

        // ------------------------------------------------------------------------
        // 자동으로 정렬되는 큐 ( 기본으로 오름차순)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(5);
        pq.add(2);
        pq.add(8);
        // [2,5,8]

        pq.poll();  // -> 2 꺼내기 (가장작은값)
        // add()    값 넣기
        // pq.offer(start + duration); // 값넣기2

        // poll()	가장 작은 값 꺼내기 (삭제됨)
        // peek()	가장 작은 값 보기 (삭제 안됨)
        // size()   크기


        //## 해쉬테이블 ###########################################################

        HashMap<String, Integer> map = new HashMap<>();
        map.put(key, value);  // 값 넣기
        map.get(key); // 값 뺴기

        map.keySet(); // 키이름을 리스트로 가져오기
        map.values(); // 결과를 리스트로 가져오기

        map.getOrDefault(name, 0) // name이 있으면 그 값을 가져오고 없으면 , 0 가져와라

        map.containsKey(key); // 포함되어있냐? 


        //## 해쉬 Set ###########################################################

        Set<Integer> set new HashSet<>();

        set.add(n);
        set.size();
        set.contains(n); // 포함여부 ture / false


        // ###########################################################

        stirng1.equals(string2);
        queue.isEmpty();
        int count = Integer.parseInt(data[1]);  
        String.valueOf(count+1);
        keyword.charAt(i);


        // # stack ##########################################################
        Stack<Integer> stack = new Stack<>();
        stack.push(n); // 값넣기
        stack.pop(); // 마지막값 꺼내기 (반환 및 삭제)
        stack.peek(); // 마지막값 확인 (삭제는안함) 

        // # StringBuilder  ##########################################################
        StringBuilder sb = new StringBuilder();
        sb.append('char'); // 문자 추가
        sb.deleteCharAt(sb.length() - 1); // 마지막 문자 제거
        sb.charAt(sb.length() - 1); // 값 확인
    }
}
