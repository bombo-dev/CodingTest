package baekjoon;

import java.io.*;
import java.util.*;
public class _1707 {

    static ArrayList<ArrayList<Integer>> graph;
    static int[] color;
    static final int RED = -1;
    static final int BLACK = 1;
    static boolean result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-->0) {
            result = true;
            graph = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine(),  " ");
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            color = new int[V + 1];

            for(int i = 0; i < V + 1; i++) {
                graph.add(new ArrayList<>());
                color[i] = 0;
            }



            for(int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                graph.get(start).add(end);
                graph.get(end).add(start);
            }

            for(int i = 1; i < V + 1; i++) {
                if(color[i] == 0) {
//                    dfs(i, RED);
                    bfs(i, RED);
                }
            }

            if(!result) {
                sb.append("NO").append("\n");
            } else {
                sb.append("YES").append("\n");
            }

        }
        System.out.print(sb);
    }

    static void dfs(int start, int colorValue){

        color[start] = colorValue;

        for(int end : graph.get(start)) {
            if(color[end] == colorValue) {
                result = false;
            }

            if(color[end] == 0) {
                dfs(end, colorValue * -1);
            }
        }
    }

    static void bfs(int start, int colorValue) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        color[start] = colorValue;

        while(!q.isEmpty()) {
            int pre = q.poll();

            for(int end : graph.get(pre)) {
                if(color[end] == color[pre]) {
                    result = false;
                }

                if(color[end] == 0) {
                    q.offer(end);
                    color[end] = color[pre] * -1;
                }
            }
        }
    }
}
