package baekjoon;

import java.io.*;
import java.util.*;
public class _2644 {
    public static final int INF = (int)1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int family = Integer.parseInt(br.readLine());
        String[] value = br.readLine().split(" ");
        int x = Integer.parseInt(value[0]);
        int y = Integer.parseInt(value[1]);
        int parent = Math.max(x, y);
        int child = Math.min(x, y);
        int[] d = new int[family + 1];
        Arrays.fill(d, INF);
        int edge = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[family + 1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < family + 1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edge; i++){
            String[] relation = br.readLine().split(" ");
            int a = Integer.parseInt(relation[0]);
            int b = Integer.parseInt(relation[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        BFS(graph, child, parent, visited, d);
        if(d[parent] != INF){
            System.out.print(d[parent]);
        } else{
            System.out.print(-1);
        }
    }

    public static void BFS(ArrayList<ArrayList<Integer>> graph, int child, int parent, boolean[] visited, int[] d){

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.offer(child);
        d[child] = 0;

        while(!dq.isEmpty()){
            int node = dq.poll();

            if(node == parent)
                break;
            if(visited[node])
                continue;
            else {
                visited[node] = true;
            }
            for(int n : graph.get(node)){
                if(!visited[n]) {
                    dq.offer(n);
                    d[n] = d[node] + 1;
                }
            }
        }
    }
}
