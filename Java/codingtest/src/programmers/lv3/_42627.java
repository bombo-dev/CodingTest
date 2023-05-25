package programmers.lv3;

import java.util.*;

class Disk implements Comparable<Disk> {
    int startTime;
    int processTime;

    public Disk(int startTime, int processTime) {
        this.startTime = startTime;
        this.processTime = processTime;
    }

    public int getWorkTime(int usedTime) {
        return (usedTime - startTime) + processTime;
    }

    @Override
    public int compareTo(Disk d) {
        return startTime - d.startTime;
    }
}
public class _42627 {
    PriorityQueue<Disk> spq = new PriorityQueue<>();
    PriorityQueue<Disk> rpq = new PriorityQueue<>((a , b) -> a.processTime - b.processTime);
    public int solution(int[][] jobs) {
        init(jobs);
        return solve();
    }

    void init(int[][] jobs) {
        for(int[] job : jobs) {
            int startTime = job[0];
            int processTime = job[1];
            spq.offer(new Disk(startTime, processTime));
        }
    }

    int solve() {
        int size = spq.size();
        int time = 0;
        int consumeTime = 0;

        // 먼저 들어온 큐가 안 비어있을 경우
        while(!spq.isEmpty()) {
            // 큐가 비어있지 않고, 맨 앞의 시작 시간이 현재 시간보다 빠른 경우
            while(!spq.isEmpty() && spq.peek().startTime <= time) {
                rpq.offer(spq.poll());
            }

            // 작업 처리에 들어온 큐중 먼저 처리가 끝나는 걸 처리
            while(!rpq.isEmpty()) {
                Disk disk = rpq.poll();
                consumeTime += disk.getWorkTime(time);
                time += disk.processTime;

                while(!rpq.isEmpty()) {
                    spq.offer(rpq.poll());
                }
            }

            // 작업 큐가 비어 있는 상태에서, 선입 큐가 비어있지 않고, 현재 시간이 다음 선행 큐보다 느릴 경우
            if(!spq.isEmpty() && time < spq.peek().startTime) {
                time = spq.peek().startTime;
            }
        }

        return consumeTime / size;
    }
}
