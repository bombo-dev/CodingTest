package baekjoon._17219;

import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int M;
    static Map<String, String> map = new HashMap<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
    static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String value = st.nextToken();
            map.put(name, value);
        }
    }

    static void solve() throws IOException {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            String find = br.readLine();
            sb.append(map.get(find)).append("\n");
        }
        System.out.print(sb);
    }


}
