package codingbook.graph;

import java.io.*;
import java.util.*;

class Edge2 implements Comparable<Edge2>{
    private int start;
    private int end;
    private int distance;

    public Edge2(int start, int end, int distance){
        this.start = start;
        this.end = end;
        this.distance = distance;
    }

    public int getStart(){
        return this.start;
    }
    public int getEnd(){
        return this.end;
    }
    public int getDistance(){
        return this.distance;
    }

    @Override
    public int compareTo(Edge2 edge){
        return this.distance - edge.distance;
    }
}
public class Question2 {
    public static List<Edge2> path = new ArrayList<>();
    public static int[] parent = new int[100001];

    public static int findParent(int x){
        if(x != parent[x])
            parent[x] = findParent(parent[x]);
        return parent[x];
    }

    public static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if( a < b ){
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] init = br.readLine().split(" ");
        int v = Integer.parseInt(init[0]);
        int e = Integer.parseInt(init[1]);
        int result = 0;
        int max = 0;

        for(int i = 1; i < v + 1; i++){
            parent[i] = i;
        }

        for(int i = 0; i < e; i++){
            String[] value = br.readLine().split(" ");
            int start = Integer.parseInt(value[0]);
            int end = Integer.parseInt(value[1]);
            int distance = Integer.parseInt(value[2]);
            path.add(new Edge2(start, end, distance));
        }
        Collections.sort(path);

        for(Edge2 edge: path){
            int a = edge.getStart();
            int b = edge.getEnd();
            if(findParent(a) != findParent(b)){
                unionParent(a, b);
                result += edge.getDistance();
                if(max < edge.getDistance())
                    max = edge.getDistance();
            }
        }
        System.out.print(result - max);
    }
}
