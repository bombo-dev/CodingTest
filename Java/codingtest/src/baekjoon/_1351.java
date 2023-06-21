package baekjoon;

import java.io.*;
import java.util.*;
public class _1351 {
    static Long N;
    static int P;
    static int Q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        Map<Long, Long> map = new HashMap<>();

        map.put(0L, 1L);

        for(long i = 1; i <= N; i++) {
            long nextValue = map.get(i / P) + map.get(i / Q);
            map.put(i, nextValue);
        }

        System.out.print(map.get(N));
    }
}
