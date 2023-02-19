package codeTree;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int direction;
    int distance;

    public Node(int direction, int distance){
        this.direction = direction;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node n){
        return this.distance - n.distance;
    }
}

public class Dijkstra_A {

    public static final int INF = (int)1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("노드의 개수를 입력해주세요 : ");
        int N = Integer.parseInt(br.readLine());

        int[] distanceArr = new int[N + 1];

        ArrayList<ArrayList<Node>> list = new ArrayList<>();

        for(int i = 0; i < N + 1; i++){
            list.add(new ArrayList<>());
        }
        Arrays.fill(distanceArr, INF);

        System.out.print("간선의 개수를 입력해주세요 : ");
        int edge = Integer.parseInt(br.readLine());
        for(int i = 0; i < edge; i++){
            System.out.print("그래프의 시작점, 끝점, 거리를 입력해주세요 : ");
            String[] graphValue = br.readLine().split(" ");
            int start = Integer.parseInt(graphValue[0]);
            int end = Integer.parseInt(graphValue[1]);
            int distance = Integer.parseInt(graphValue[2]);
            list.get(start).add(new Node(end, distance));
        }

        System.out.print("시작 노드를 입력해주세요 : ");
        int startNode = Integer.parseInt(br.readLine());
        distanceArr[startNode] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startNode, 0));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int direction = node.direction;
            int distance = node.distance;

            if(distance > distanceArr[direction])
                continue;

            for(Node n : list.get(direction)){
                int cost = distanceArr[direction] + n.distance;

                if(distanceArr[n.direction] > cost) {
                    distanceArr[n.direction] = cost;
                    pq.offer(new Node(n.direction, cost));
                }
            }
        }
        for(int i = 1; i < N + 1; i++){
            System.out.println(i + "번 째 노드까지의 최단 거리 : " + distanceArr[i]);
        }
    }
}
