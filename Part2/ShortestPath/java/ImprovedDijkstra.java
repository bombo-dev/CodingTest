import java.io.*;
import java.util.*;

public class ImprovedDijkstra {
    public final static int INF = (int)1e9;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void dijkstra(int start, int[] d){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int index = node.getIndex();
            int distance = node.getDistance();

            if(d[index] < distance) continue;

            for(Node now: graph.get(index)){
                int cost = d[index] + now.getDistance();
                if(cost < d[now.getIndex()]){
                    d[now.getIndex()] = cost;
                    pq.offer(new Node(now.getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] init = br.readLine().split(" ");
        int v = Integer.parseInt(init[0]);
        int e = Integer.parseInt(init[1]);

        int[] d = new int[v + 1];

        for(int i = 0; i < v + 1; i++){
            graph.add(new ArrayList<Node>());
        }
        int start = Integer.parseInt(br.readLine().trim());

        for(int i = 0; i < e; i++){
            String[] value = br.readLine().split(" ");
            int a = Integer.parseInt(value[0]);
            int b = Integer.parseInt(value[1]);
            int c = Integer.parseInt(value[2]);
            graph.get(a).add(new Node(b, c));
        }

        Arrays.fill(d, INF);

        dijkstra(start, d);

        for(int shortest: d){
            if(shortest == INF){
                System.out.println("INF");
            } else{
                System.out.println(shortest);
            }
        }
    }
}
