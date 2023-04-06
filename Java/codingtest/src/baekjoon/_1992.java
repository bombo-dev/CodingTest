package baekjoon;

import java.io.*;
import java.util.*;
public class _1992 {
    static int[][] graph;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        for(int i = 0; i < N; i++){
            String value = br.readLine();
            for(int j = 0; j < N; j++){
                graph[i][j] = Character.getNumericValue(value.charAt(j));
            }
        }
        StringBuilder sb = new StringBuilder();
        recursion(0, 0, N, sb);
        System.out.print(sb.toString());
    }

    static void recursion(int x, int y, int size, StringBuilder sb) {
        int startValue = graph[x][y];
        boolean isCheck = false;
        Loop1: for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(graph[i][j] != startValue) {
                    isCheck = true;
                    size /= 2;
                    sb.append("(");
                    recursion(x, y, size, sb);
                    recursion(x, y + size, size, sb);
                    recursion(x + size, y, size, sb);
                    recursion(x + size, y + size, size, sb);
                    sb.append(")");
                    break Loop1;
                }
            }
        }
        if(!isCheck)
            sb.append(startValue);
    }
}
