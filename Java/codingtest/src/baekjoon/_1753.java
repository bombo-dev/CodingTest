package baekjoon;

import java.io.*;
import java.util.*;

class DijkstraNode implements Comparable<DijkstraNode>{
    int direction;
    int distance;

    public DijkstraNode(int direction, int distance){
        this.direction = direction;
        this.distance = distance;
    }

    @Override
    public int compareTo(DijkstraNode n){
        return this.distance - n.distance;
    }
}

public class _1753 {
    public static final int INF = (int)1e9;
    public static int V;
    public static int E;
    public static int[] d;
    public static ArrayList<ArrayList<DijkstraNode>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        d = new int[V + 1];
        Arrays.fill(d, INF);

        graph = new ArrayList<>();
        for(int i = 0; i < V + 1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int distance = Integer.parseInt(st2.nextToken());
            graph.get(a).add(new DijkstraNode(b, distance));
        }
        dijkstra(start);



        for(int i = 1; i <= V; i++){
            if(d[i] == INF)
                System.out.println("INF");
            else
                System.out.println(d[i]);
        }
    }

    public static void dijkstra(int start){
        PriorityQueue<DijkstraNode> pq = new PriorityQueue<>();
        d[start] = 0;
        pq.offer(new DijkstraNode(start, 0));

        while(!pq.isEmpty()){
            DijkstraNode now = pq.poll();
            int now_direction = now.direction;
            int now_distance = now.distance;

            if(d[now_direction] < now_distance)
                continue;

            for(DijkstraNode node : graph.get(now_direction)){

                if(d[node.direction] > d[now_direction] + node.distance){
                    d[node.direction] = d[now_direction] + node.distance;
                    pq.offer(new DijkstraNode(node.direction, d[now_direction] + node.distance));
                }
            }
        }
    }
}
