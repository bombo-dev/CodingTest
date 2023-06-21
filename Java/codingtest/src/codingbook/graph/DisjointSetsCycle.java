package codingbook.graph;

import java.io.*;
public class DisjointSetsCycle {

    public static int[] parent = new int[100001];

    public static int findParent(int x){
        if(x != parent[x]){
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }

    public static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if(a < b){
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String init[] = br.readLine().split(" ");
        int v = Integer.parseInt(init[0]);
        int e = Integer.parseInt(init[1]);
        boolean cycle = false;

        for(int i = 1; i < v + 1; i++){
            parent[i] = i;
        }

        for(int i = 0; i < e; i++){
            String[] value = br.readLine().split(" ");
            int n1 = Integer.parseInt(value[0]);
            int n2 = Integer.parseInt(value[1]);
            if(findParent(n1) == findParent(n2)){
                cycle = true;
            } else {
                unionParent(n1, n2);
            }
        }

        if(cycle){
            System.out.print("사이클이 발생했습니다.");
        } else {
            System.out.print("사이클이 발생하지 않았습니다.");
        }
    }
}
