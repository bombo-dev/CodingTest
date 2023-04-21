package baekjoon;

import java.io.*;
import java.util.*;
public class _11725 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            unionParent(a, b);
        }

        for (int i = 2; i < N + 1; i++) {
            System.out.println(parent[i]);
        }
    }

    static int findParent(int a) {
        if (a == parent[a]) {
            return a;
        }
        return findParent(parent[a]);
    }

    static void unionParent(int a, int b) {
        int parent_a = findParent(a);
        int parent_b = findParent(b);

        if (parent_a < parent_b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}
