package codingbook.shortestPath;

import java.util.*;
import java.io.*;

public class Question2 {
    public static List<ArrayList<Node>> graph = new ArrayList<>();
    public static final int INF = (int)1e9;

    public static void dijkstra(int start, int[] d){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int now = node.getIndex();
            int distance = node.getDistance();

            if(d[now] < distance) continue;

            for(Node n: graph.get(now)){
                int cost = d[now] + n.getDistance();
                if(cost < d[n.getIndex()]){
                    d[n.getIndex()] = cost;
                    pq.offer(new Node(n.getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] init = br.readLine().split(" ");
        int n = Integer.parseInt(init[0]);
        int e = Integer.parseInt(init[1]);
        int start = Integer.parseInt(init[2]);

        int [] d = new int[n + 1];

        for(int i = 0; i < n + 1; i++){
            graph.add(new ArrayList<Node>());
        }

        for(int i = 0; i < e; i++){
            String[] value = br.readLine().split(" ");
            int a = Integer.parseInt(value[0]);
            int b = Integer.parseInt(value[1]);
            int c = Integer.parseInt(value[2]);
            graph.get(a).add(new Node(b, c));
        }

        Arrays.fill(d, INF);

        int count = 0;
        int result = 0;
        dijkstra(start, d);

        for(int i = 1; i < n + 1; i++){
            if(d[i] < INF){
                count += 1;
                if(result < d[i]){
                    result = d[i];
                }
            }
        }
        System.out.print(count - 1  + " " + result);
    }
}
