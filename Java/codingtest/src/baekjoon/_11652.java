package baekjoon;

import java.io.*;
import java.util.*;

// Map 에 대한 Value 정렬 -> List<Map.Entry<K, V>> list = new List<>(map.entrySet());
// 혹은 Stream 사용. map.entrySet().stream()
public class _11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            long index = Long.parseLong(br.readLine());
            map.put(index, map.getOrDefault(index, 0) + 1);
        }

        List<Map.Entry<Long, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Long, Integer>>() {

            @Override
            public int compare(Map.Entry<Long, Integer> o1, Map.Entry<Long, Integer> o2) {
                if(o1.getValue().equals(o2.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue() - o1.getValue();
            }
        });

        System.out.print(list.get(0).getKey());
    }
}
