package programmers.lv2;
import java.util.*;
// 귤 고르기
public class _138476 {

    public static void main(String[] args){
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2 ,3};
        System.out.println(solution(6, tangerine));
    }

    public static int solution(int k, int[] tangerine) {
        // 개수가 제일 많은 것이 제일 앞에 오도록 정렬을 해야한다.
        // 제일 베스트는 radix 정렬 인 것 같긴하다.
        int answer = 1;

        Integer[] radix = new Integer[10000001];
        Arrays.fill(radix, 0);

        for(int i = 0; i < tangerine.length; i++){
            radix[tangerine[i]] = radix[tangerine[i]] + 1;
        }

        Arrays.sort(radix, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int i = 0;
        while(k > 0){
            System.out.println("현재 radix[" + i + "] : " + radix[i]);
            if(radix[i] == 0){
                answer++;
                i++;
            } else{
                radix[i] -= 1;
                k--;
            }
        }

        return answer;
    }

    // 회고해야 하는 부분
    public static int solution2(int k, int[] tangerine){
        int answer = 0;
        HashMap<Integer,Integer> map =new HashMap<>();

        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2)-map.get(o1));

        for(Integer key:list){
            k -=map.get(key);
            answer++;
            if(k<=0){
                break;
            }
        }

        return answer;
    }
}
