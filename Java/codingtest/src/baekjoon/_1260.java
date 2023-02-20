package baekjoon;
import java.io.*;
import java.util.*;
public class _1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] initValue = br.readLine().split(" ");
        int node = Integer.parseInt(initValue[0]);
        int edge = Integer.parseInt(initValue[1]);
        int start = Integer.parseInt(initValue[2]);

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i < node + 1; i++){
            list.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[node + 1];
        for(int i = 0; i < edge; i++){
            String[] graph = br.readLine().split(" ");
            int a = Integer.parseInt(graph[0]);
            int b = Integer.parseInt(graph[1]);
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i = 1; i < node + 1; i++){
            Collections.sort(list.get(i));
        }

        DFS(list, visited, start);
        System.out.println();
        BFS(list, visited, start);
    }

    public static void DFS(ArrayList<ArrayList<Integer>> list, boolean[] visited, int start){

        if(!visited[start]){
            System.out.print(start + " ");
            visited[start] = true;
        }

        for(Integer destination : list.get(start)){
            if(!visited[destination])
                DFS(list, visited, destination);
        }
    }

    public static void BFS(ArrayList<ArrayList<Integer>> list, boolean[] visited, int start){

        Arrays.fill(visited, false);
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.offer(start);
        while(!dq.isEmpty()){
            int startingPoint = dq.poll();
            if(visited[startingPoint])
                continue;
            else
                visited[startingPoint] = true;
            System.out.print(startingPoint + " ");
            for(Integer destination : list.get(startingPoint)){
                dq.offer(destination);
            }
        }
    }
}
