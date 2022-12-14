import java.util.*;
import java.io.*;
public class Question1a {

    public static final int INF = (int)1e9;
    public static List<ArrayList<Node>> graph = new ArrayList<>();

    public static void dijkstra(int start, int[] d){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int now = node.getIndex();
            int distance = node.getDistance();

            if(d[now] < distance) continue;

            for(Node n : graph.get(now)){
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

        int[] d = new int[n + 1];

        for(int i = 0; i < n + 1; i++){
            graph.add(new ArrayList<Node>());
        }

        for(int i = 0; i < e; i++){
            String[] value = br.readLine().split(" ");
            int a = Integer.parseInt(value[0]);
            int b = Integer.parseInt(value[1]);
            graph.get(a).add(new Node(b, 1));
            graph.get(b).add(new Node(a, 1));
        }
        Arrays.fill(d, INF);

        String[] xk = br.readLine().split(" ");
        int x = Integer.parseInt(xk[0]);
        int k = Integer.parseInt(xk[1]);

        int result = 0;

        dijkstra(1, d);
        result += d[k];

        Arrays.fill(d, INF);
        dijkstra(k, d);

        result += d[x];

        if(result >= INF){
            System.out.println("INFINITY");
        } else {
            System.out.println(result);
        }

    }
}
