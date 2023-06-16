package study._1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<String> result = new ArrayList<>();
    static int L;
    static int C;
    static StringBuilder sb;
    static String[] token;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        token = new String[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            token[i] = st.nextToken();
        }
        Arrays.sort(token);

        sb = new StringBuilder();
        backTracking(0, 0, 0, 0);


        for (String value : result) {
            System.out.println(value);
        }
    }

    static void backTracking(int start, int consonant, int vowel, int depth) {

        if (depth == L - 1 && consonant == 0) {
            return;
        }

        if (depth == L && vowel == 0) {
            return;
        }

        if (depth == L && consonant >= 2 && vowel >= 1) {
            result.add(sb.toString());
            return;
        }

        for (int i = start; i < C; i++) {
            sb.append(token[i]);
            if (isVowel(token[i])) {
                backTracking(i + 1, consonant, vowel + 1, depth + 1);
            } else {
                backTracking(i + 1, consonant + 1, vowel, depth + 1);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    static boolean isVowel(String value) {
        return value.equals("a") || value.equals("e") || value.equals("i") || value.equals("o") || value.equals("u");
    }
}
