package baekjoon;

import java.io.*;
import java.util.*;

public class _2606 {
    public static int DFS_count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < node + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);

        }

        boolean[] visited = new boolean[node + 1];
        DFS(graph, visited, 1);
        System.out.print("BFS : " + BFS(graph, visited, 1));
    }

    public static int BFS(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int start) {
        Arrays.fill(visited, false);

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int count = 0;
        dq.offer(start);
        while (!dq.isEmpty()) {
            int node = dq.poll();
            if (visited[node])
                continue;
            else {
                visited[node] = true;
                count++;
            }
            for (Integer n : graph.get(node)) {
                if (!visited[n]) {
                    dq.offer(n);
                }
            }
        }
        return count - 1;
    }

    public static void DFS(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int search) {

        visited[search] = true;
        for (Integer node : graph.get(search)) {
            if (!visited[node]) {
                DFS(graph, visited, node);
                DFS_count++;
            }
        }

        if(search == 1)
            System.out.println("DFS : " + DFS_count);
    }
}
