package codingbook.bfs;

import java.io.*;
import java.util.*;

class Node {
    int x;
    int y;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
public class Question2 {
    public static int n, m;

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int[][] graph = new int[200][200];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] count = br.readLine().split(" ");
        n = Integer.parseInt(count[0]);
        m = Integer.parseInt(count[1]);

        for(int i = 0; i < n; i++){
            String value = br.readLine();
            for(int j = 0; j < m; j++){
                graph[i][j] = Character.getNumericValue(value.charAt(j));
            }
        }
        bfs(0, 0);
        System.out.print(graph[n-1][m-1]);
    }

    public static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        while(!q.isEmpty()){
            Node node = q.poll();
            int px = node.getX();
            int py = node.getY();
            int value = graph[px][py];
            for(int i = 0; i < 4; i++){
                int nx = px + dx[i];
                int ny = py + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if(graph[nx][ny] == 1){
                    graph[nx][ny] = value + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }
}
