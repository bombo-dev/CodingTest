package codeTree;

import java.io.*;
import java.util.*;
public class Prim_A {
    public static void main(String[] args) throws IOException {
        final int INF = (int)1e9;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] d = new int[N + 1];

        Arrays.fill(d, INF);

        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for(int i = 0; i < N + 1; i++){
            list.add(new ArrayList<>());
        }



        int edge = Integer.parseInt(br.readLine());
        for(int i = 0; i < edge; i++){
            String[] graphValue = br.readLine().split(" ");
            int start = Integer.parseInt(graphValue[0]);
            int end = Integer.parseInt(graphValue[1]);
            int distance = Integer.parseInt(graphValue[2]);
            list.get(start).add(new Node(end, distance));
        }
        prim(list, d, 1);

    }

    public static void prim(ArrayList<ArrayList<Node>> list, int[] d, int start){
        d[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int direction = node.direction;
            int distance = node.distance;

            if(d[direction] < distance)
                continue;
            System.out.print(direction + " ");
            for(Node n : list.get(direction)){
                if(n.distance < d[n.direction]) {
                    d[n.direction] = n.distance;
                    pq.offer(new Node(n.direction, n.distance));
                }
            }
        }
    }
}
