package baekjoon;

import java.io.*;
import java.util.*;
public class _2630 {
    static int[][] paper;
    static int white = 0;
    static int blue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(0, 0, N);

        System.out.println(white);
        System.out.print(blue);
    }

    public static void recursion(int x, int y, int size) {

        int start = paper[x][y];
        boolean changed = false;

        Loop1 : for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(paper[i][j] != start) {
                    changed = true;
                    size /= 2;
                    recursion(x, y, size);
                    recursion(x, y + size, size);
                    recursion(x + size, y, size);
                    recursion(x + size, y + size, size);
                    break Loop1;
                }
            }
        }

        if(!changed) {
            if(start == 1) {
                blue++;
            } else {
                white++;
            }
        }
    }
}
