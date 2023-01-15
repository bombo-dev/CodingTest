package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15650 {

    static boolean[] visited;
    static int[] arr;
    static int[] resultArr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        visited = new boolean[a];
        arr = new int[a];
        resultArr = new int[b];

        DFS(a, b, 0);
        System.out.println("========= 재귀 백트래킹 =======");
        comb(a, b, 0);
        System.out.println("========= 조합 다른 방법 =======");
        comb2(a, b, 0, 0);
    }

    // 배열에서 선택했을 경우에는 배열에 true 를 해줌으로써 해당 인덱스는 무시하고 뽑아야 하는 개수를 1개 줄인다.
    public static void DFS(int n, int r, int start){

        if(r == 0){
            print(arr, visited, n);
        }

        for(int i = start; i < n; i++){
            visited[i] = true;
            DFS(n, r - 1, i + 1);
            visited[i] = false;
        }
    }

    public static void comb(int n, int r, int depth){
        if(r == 0){
            print(arr, visited, n);
            return;
        }

        if(depth == n)
            return;

        visited[depth] = true;
        comb(n, r - 1, depth + 1);
        visited[depth] = false;
        comb(n, r, depth + 1);
    }

    public static void comb2(int n, int r, int index, int target){
        if(r == 0){
            targetPrint();
        }

        if(target == n){
            return;
        }

        resultArr[index] = target;
        comb2(n , r - 1, index + 1, target + 1);
        comb2(n, r, index, target + 1);
    }


    public static void print(int[] arr, boolean[] visited, int n){
        for (int i = 0; i < n; i++){
            if(visited[i]) {
                System.out.print(i + 1 + " ");
            }
        }
        System.out.println();
    }

    public static void targetPrint(){
        for(int i = 0; i < resultArr.length; i++){
            System.out.print(resultArr[i] + " ");
        }
        System.out.println();
    }
}
