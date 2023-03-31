package baekjoon;

import java.io.*;
import java.util.*;
public class _1074 {
    static int N;
    static int r;
    static int c;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = ist(st.nextToken());
        r = ist(st.nextToken());
        c = ist(st.nextToken());

        int size = (int)Math.pow(2, N);

        recursion(0, 0, size);

    }
    public static int ist(String s) {
        return Integer.parseInt(s);
    }

    public static void recursion(int x, int y, int size) {

        if(x == r && y == c) {
            System.out.print(answer);
            return;
        }

        if(r >= x && r < x + size && c >= y && c < y + size) {
            // 1
            recursion(x, y, size / 2);
            // 2
            recursion(x, y + (size / 2), size / 2);
            // 3
            recursion(x + (size / 2), y, size / 2);
            // 4
            recursion(x + (size / 2), y + (size / 2), size / 2);
        } else {
            answer += size * size;
        }
    }
}
