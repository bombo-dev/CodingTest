package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15650A {

    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        visited = new boolean[n];

        comb(n, r, 0);
    }

    public static void comb(int n, int r, int depth){
        if(r == 0){
            print();
            return;
        }
        if(n == depth)
            return;

        visited[depth] = true;
        comb(n, r - 1, depth + 1);
        visited[depth] = false;
        comb(n, r, depth + 1);
    }

    public static void print(){
        for(int i = 0; i < visited.length; i++){
            if(visited[i])
                System.out.print((i + 1) + " ");
        }
        System.out.println();
    }
}
