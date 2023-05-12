package baekjoon._9375;

import java.io.*;
import java.util.*;
public class Main {
    static int T;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<String, Integer> map;
    static int result;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        T = stoi(br.readLine());
    }

    static void solve() throws IOException {
        for(int i = 0; i < T; i++) {
            result = 0;
            map = new LinkedHashMap<>();
            int N = stoi(br.readLine());

            for(int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(),  " ");
                String name = st.nextToken();
                String type = st.nextToken();
                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            int answer = calc();
            System.out.println(answer);
        }
    }

    static int calc() {
        int result = 1;
        for(String key : map.keySet()) {
            result *= (map.get(key) + 1);
        }
        result -= 1;

        return result;
    }

    static int stoi(String value) {
        return Integer.parseInt(value);
    }
}
