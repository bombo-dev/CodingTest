package programmers.lv2;

import java.util.*;

class Node implements Comparable<Node> {
    int index;
    int distance;

    Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int compareTo(Node n) {
        return this.distance - n.distance;
    }
}
public class _12978 {
    ArrayList<ArrayList<Node>> list = new ArrayList<>();
    int[] distanceMap;

    public int solution(int N, int[][] road, int K) {
        init(N, road);
        dijkstra(1);
        return result(N, K);
    }

    void init(int N, int[][] road) {
        for(int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        distanceMap = new int[N + 1];
        Arrays.fill(distanceMap, (int)1e9);

        for(int[] ro : road) {
            int start = ro[0];
            int end = ro[1];
            int distance = ro[2];

            list.get(start).add(new Node(end, distance));
            list.get(end).add(new Node(start, distance));
        }
    }


    void dijkstra(int st) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(st, 0));
        distanceMap[st] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int index = node.index;
            int distance = node.distance;

            if(distanceMap[index] < distance)
                continue;

            for(Node newNode : list.get(index)) {
                int cost = distance + newNode.distance;
                if(distanceMap[newNode.index] > cost) {
                    distanceMap[newNode.index] = cost;
                    pq.offer(new Node(newNode.index, cost));
                }
            }
        }
    }

    int result(int N, int K) {
        int count = 0;

        for(int i = 1; i < N + 1; i++) {
            if(distanceMap[i] <= K)
                count++;
        }

        return count;
    }
}
