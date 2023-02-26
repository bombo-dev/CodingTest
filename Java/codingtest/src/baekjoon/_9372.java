package baekjoon;

import java.io.*;
import java.util.*;

class KruskalNode implements Comparable<KruskalNode> {

    int from;
    int to;
    int distance;

    public KruskalNode(int from, int to, int distance){
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    @Override
    public int compareTo(KruskalNode node){
        return this.distance - node.distance;
    }
}
public class _9372 {
    static int T;
    static int[] parent;
    static ArrayList<KruskalNode> kruskalGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int minCount = 0;
            kruskalGraph = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int nation = Integer.parseInt(st.nextToken());
            int airplane = Integer.parseInt(st.nextToken());
            parent = new int[nation + 1];
            for(int p = 1; p < nation + 1; p++){
                parent[p] = p;
            }

            for(int j = 0; j < airplane; j++){
                StringTokenizer st2 = new StringTokenizer(br.readLine(),  " ");
                int a = Integer.parseInt(st2.nextToken());
                int b = Integer.parseInt(st2.nextToken());
                kruskalGraph.add(new KruskalNode(a, b, 1));
                kruskalGraph.add(new KruskalNode(b, a, 1));
            }

            for(KruskalNode node : kruskalGraph){
                if(findParent(node.from) == findParent(node.to))
                    continue;
                else {
                    unionParent(node.from, node.to);
                    minCount++;
                }
            }
            System.out.println(minCount);
        }
    }

    public static int findParent(int a){
        if(a != parent[a])
            parent[a] = findParent(parent[a]);

        return parent[a];
    }

    public static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);

        parent[b] = a;
    }

}
