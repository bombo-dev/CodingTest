package baekjoon;

import java.util.*;

class Position implements Comparable<Position> {
    int position;
    int time;

    public Position(int position, int time){
        this.position = position;
        this.time = time;
    }

    @Override
    public int compareTo(Position p){
        return this.time - p.time;
    }
}
public class _1697 {
    static int[] dx = {-1, 1, 2};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();

        int[] timeArr = new int[100001];
        Arrays.fill(timeArr, 20);

        PriorityQueue<Position> pq = new PriorityQueue<>();
        pq.offer(new Position(start, 0));
        timeArr[start] = 0;
        while(!pq.isEmpty()){
            Position position = pq.poll();
            int now = position.position;
            int time = position.time;

            dx[2] = now;

            if(now == end)
                break;

            for(int i = 0; i < 3; i++){
                int nx = now + dx[i];
                if(nx < 0 || nx > 100001 || timeArr[nx] <= time + 1)
                    continue;

                pq.offer(new Position(nx, time + 1));
                timeArr[nx] = time + 1;
            }
        }
        System.out.print(timeArr[end]);
    }
}
