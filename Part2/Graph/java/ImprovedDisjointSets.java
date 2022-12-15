import java.io.*;
public class ImprovedDisjointSets {
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
        } else{
            parent[a] = b;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] init = br.readLine().split(" ");
        int v = Integer.parseInt(init[0]);
        int e = Integer.parseInt(init[1]);

        for(int i = 1; i < v + 1; i++){
            parent[i] = i;
        }

        for(int i = 0; i < e; i++){
            String[] value = br.readLine().split(" ");
            int a = Integer.parseInt(value[0]);
            int b = Integer.parseInt(value[1]);
            unionParent(a, b);
        }
        System.out.print("각 원소가 속한 집합 : ");
        for(int i = 1; i < v + 1; i++){
            System.out.print(findParent(i) +" ");
        }
        System.out.println();
        System.out.print("부모 테이블 : ");
        for(int i = 1; i < v + 1; i++){
            System.out.print(parent[i] + " ");
        }
    }
}
