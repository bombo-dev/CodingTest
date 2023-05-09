package baekjoon._1764;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Set<String> set = new HashSet<>();
    static List<String> list = new ArrayList<>();
    static int count = 0;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
    }

    static void solve() throws IOException {
        for(int i = 0; i < M; i++) {
            String value = br.readLine();
            if(!set.add(value)) {
                list.add(value);
                count++;
            }
        }
        Collections.sort(list);
        System.out.println(count);
        for(String value : list) {
            System.out.println(value);
        }
    }
}
