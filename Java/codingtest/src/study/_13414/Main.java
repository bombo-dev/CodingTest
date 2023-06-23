package study._13414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int K;
    static int L;
    static Set<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        init();
        set.stream()
                .limit(K)
                .forEach(System.out::println);
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        for (int i = 0; i < L; i++) {
            String input = br.readLine();
            if (set.contains(input)) {
                set.remove(input);
            }
            set.add(input);
        }
    }
}
