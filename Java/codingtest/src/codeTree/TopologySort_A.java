package codeTree;

import java.io.*;
import java.util.*;
public class TopologySort_A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for(int i = 0; i < N + 1; i++){
            list.add(new ArrayList<>());
        }

        int[] inDegree = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        for(int i = 0; i < edge; i++){
            String[] value = br.readLine().split(" ");
            int start = Integer.parseInt(value[0]);
            int destination = Integer.parseInt(value[1]);
            list.get(start).add(new Node(destination, 0));
            inDegree[destination]++;
        }

        for(int i = 1; i <= N; i++){
            System.out.print(inDegree[i] + " ");
        }
        System.out.println();

        for(int i = 1; i <= N; i++){
            int checkIndex = 0;
            for(int j = N; j >= 1; j--){
                if(visited[j] != true && inDegree[j] == 0) {
                    checkIndex = j;
                    visited[j] = true;
                    System.out.println("탐색하는 인덱스 : " + checkIndex);
                    break;
                }
            }
            for(Node node : list.get(checkIndex)){
                inDegree[node.direction]--;
            }
            print(inDegree, N, i);
        }
    }

    public static void print(int[] inDegree, int N, int count){
        System.out.println(count + "번 째의 inDegree 출력");
        for(int i = 1; i <= N; i++){
            System.out.print(inDegree[i] + " ");
        }
        System.out.println();
    }

}
