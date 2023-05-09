package baekjoon._1931;

import java.io.*;
import java.util.*;

class Meeting implements Comparable<Meeting> {
    int startTime;
    int endTime;

    Meeting(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getSubTime() {
        return endTime - startTime;
    }

    @Override
    public int compareTo(Meeting o) {
        if(this.endTime == o.endTime) {
            return this.startTime - o.startTime;
        }
        return this.endTime - o.endTime;
    }

    @Override
    public String toString() {
        return "startTime : " + startTime + "endTime : " + endTime;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Meeting> pq = new PriorityQueue<>();
    static Stack<Meeting> stack = new Stack<>();
    static int N;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.offer(new Meeting(start, end));
        }
    }

    static void solve() {
        int count = 0;
        int preEndTime = pq.poll().endTime;
        count++;
        while(!pq.isEmpty()) {
            Meeting meeting = pq.poll();
            if(meeting.startTime >= preEndTime) {
                count++;
                preEndTime = meeting.endTime;
            }
        }

        System.out.print(count);
    }
}
