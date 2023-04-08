package baekjoon;

import java.io.*;
import java.util.*;

public class _1759 {
    static int N;
    static int M;
    static char[] arr;
    static char[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        arr = new char[N];
        result = new char[M];
        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
        backTracking(0, M, 0, 0, 1, 2);

        System.out.print(sb.toString());
    }

    static void backTracking(int depth, int findDepth, int start, int target, int consonant, int vowel) {
        if (depth == findDepth && consonant <= 0 && vowel <= 0) {
            for (char v : result) {
                sb.append(v);
            }
            sb.append("\n");
            return;
        }

        if (target >= M)
            return;


        for (int i = start; i < N; i++) {
            result[target] = arr[i];

            if (isConsonant(arr[i])) {
                backTracking(depth + 1, findDepth, i + 1, target + 1, --consonant, vowel);
                consonant++;
            } else {
                backTracking(depth + 1, findDepth, i + 1, target + 1, consonant, --vowel);
                vowel++;
            }
        }
    }

    static boolean isConsonant(char a) {
        if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u')
            return true;
        return false;
    }
}
