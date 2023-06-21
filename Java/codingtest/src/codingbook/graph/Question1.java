package codingbook.graph;

import java.io.*;
public class Question1 {
    public static int[] parent = new int[100001];

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
        } else {
            parent[a] = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] init = br.readLine().split(" ");
        int v = Integer.parseInt(init[0]);
        int e = Integer.parseInt(init[1]);

        for(int i = 1; i < v + 1; i++){
            parent[i] = i;
        }

        for(int i = 0; i < e; i++){
            String[] value = br.readLine().split(" ");
            int oper = Integer.parseInt(value[0]);
            int a = Integer.parseInt(value[1]);
            int b = Integer.parseInt(value[2]);
            if(oper == 0){
                unionParent(a, b);
            } else {
                if(findParent(a) == findParent(b)){
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }
        System.out.print(sb);
    }
}
