package codingbook.graph;

import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    private int start;
    private int dest;
    private int distance;
    public Edge(int start, int dest, int distance) {
        this.start = start;
        this.dest = dest;
        this.distance = distance;
    }

    public int getStart() {
        return start;
    }

    public int getDest() {
        return dest;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Edge Edge){
        return this.distance - Edge.distance;
    }
}
public class Kruskal {
    public static int[] parent = new int[100001];
    public static List<Edge> list = new ArrayList<>();

    public static int findParent(int x){
        if(x != parent[x])
            parent[x] = findParent(parent[x]);

        return parent[x];
    }

    public static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if(a < b){
            parent[b] = a;
        } else{
            parent[a] = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] init = br.readLine().split(" ");
        int v = Integer.parseInt(init[0]);
        int e = Integer.parseInt(init[1]);

        int result = 0;

        for(int i = 1; i < v + 1; i++){
            parent[i] = i;
        }

        for(int i = 0; i < e; i++){
            String[] value = br.readLine().split(" ");
            int start = Integer.parseInt(value[0]);
            int end = Integer.parseInt(value[1]);
            int distance = Integer.parseInt(value[2]);
            list.add(new Edge(start, end, distance));
        }
        Collections.sort(list);

        for(Edge Edge : list){
            if(parent[Edge.getStart()] == parent[Edge.getDest()]){
                continue;
            } else {
                unionParent(Edge.getStart(), Edge.getDest());
                result += Edge.getDistance();
            }
        }

        System.out.print(result);
    }
}
