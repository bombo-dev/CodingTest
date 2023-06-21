package codingbook.shortestPath;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    private int index;
    private int distance;

    Node(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Node node){
        return this.distance - node.distance;
    }
}

public class SimpleDijkstra {
    public static int INF = (int) 1e9;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static int smallestNode(int[] distance, boolean[] visited){
        int min = INF;
        int smallestIndex = 0;
        for(int i = 0; i < distance.length; i++){
            if(!visited[i] && distance[i] < min){
                min = distance[i];
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static void dijkstra(int start, int[] distance, boolean[] visited){
        distance[start] = 0;
        visited[start] = true;

        for(Node node: graph.get(start)) {
            distance[node.getIndex()] = node.getDistance();
        }

        for(int i = 0; i < distance.length - 1; i++){
            int smallIndex = smallestNode(distance, visited);
            visited[smallIndex] = true;

            for(Node node: graph.get(smallIndex)){
                int cost = distance[smallIndex] + node.getDistance();
                if(cost < distance[node.getIndex()]){
                    distance[node.getIndex()] = cost;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] init = br.readLine().split(" ");
        int nodeCount = Integer.parseInt(init[0]);
        int edgeCount = Integer.parseInt(init[1]);

        int[] distance = new int[nodeCount + 1];
        boolean[] visited = new boolean[nodeCount + 1];
        int start = Integer.parseInt(br.readLine().trim());

        for(int i = 0 ; i < nodeCount + 1; i++){
            graph.add(new ArrayList<Node>());
        }

        for(int i = 0; i < edgeCount; i++){
            String[] node = br.readLine().split(" ");
            int index = Integer.parseInt(node[0]);
            int edge = Integer.parseInt(node[1]);
            int money = Integer.parseInt(node[2]);
            graph.get(index).add(new Node(edge, money));
        }

        Arrays.fill(distance, INF);
        dijkstra(start, distance, visited);

        for(int i = 1; i < distance.length; i++){
            if(distance[i] == INF){
                System.out.println("INF");
            } else{
                System.out.println(distance[i]);
            }
        }
    }
}
