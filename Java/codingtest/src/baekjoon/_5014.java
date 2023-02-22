package baekjoon;

import java.io.*;
import java.util.*;

class Elevator implements Comparable<Elevator> {
    int position;
    int count;

    public Elevator(int position, int count){
        this.position = position;
        this.count = count;
    }

    @Override
    public int compareTo(Elevator e){
        return this.count - e.count;
    }
}

public class _5014 {

    public static final int INF = (int)1e9;
    public static int totalFloor;
    public static int present;
    public static int company;
    public static int up;
    public static int down;
    public static int[] dx = new int[2];
    public static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        totalFloor = Integer.parseInt(st.nextToken());
        present = Integer.parseInt(st.nextToken());
        company = Integer.parseInt(st.nextToken());
        up = Integer.parseInt(st.nextToken());
        down = Integer.parseInt(st.nextToken());

        visited = new boolean[totalFloor + 1];

        dx[0] = up;
        dx[1] = -down;

        int[] d = new int[totalFloor + 1];

        Arrays.fill(d, INF);
        dijkstra(d, present, visited);


        if(d[company] == INF){
            System.out.print("use the stairs");
        } else {
            System.out.print(d[company]);
        }
    }

    public static void dijkstra(int[] d, int start, boolean[] visited){
        PriorityQueue<Elevator> pq = new PriorityQueue<>();
        d[start] = 0;
        visited[start] = true;
        pq.offer(new Elevator(start, 0));

        while(!pq.isEmpty()){
            Elevator e = pq.poll();
            int position = e.position;
            int count = e.count;

            for(int i = 0; i < 2; i++){
                int nx = position + dx[i];

                if(nx < 1 || nx > totalFloor || count + 1 > d[nx] || visited[nx])
                    continue;

                pq.offer(new Elevator(nx, count + 1));
                visited[nx] = true;
                d[nx] = count + 1;
            }
        }
    }
}
