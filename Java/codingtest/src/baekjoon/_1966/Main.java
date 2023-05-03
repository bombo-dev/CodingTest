package baekjoon._1966;

import java.io.*;
import java.util.*;

class Document implements Comparable<Document>{
    int index;
    int priority;

    Document(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }

    @Override
    public int compareTo(Document o) {
        return o.priority - this.priority;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static HashMap<Integer, Integer> pqMap;
    static StringBuilder sb = new StringBuilder();
    static int T;

    public static void main(String[] args) throws IOException {
        T = stoi(br.readLine());
        play();
        System.out.print(sb);
    }

    static void play() throws IOException {
        while(T--> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            Queue<Document> q = new LinkedList<>();
            pqMap = new HashMap<>();
            int N = stoi(st.nextToken());
            int M = stoi(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) {
                int priority = stoi(st.nextToken());
                q.offer(new Document(i, priority));
                pqMap.put(priority, pqMap.getOrDefault(priority, 0) + 1);
            }
            PriorityQueue<int[]> pq = priorityInit(pqMap);
            find(q, pq, M);
        }
    }

    static PriorityQueue<int[]> priorityInit(Map<Integer, Integer> map){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return b[0] - a[0];
        });

        for(int key : map.keySet()) {
            pq.offer(new int[]{key, map.get(key)});
        }

        return pq;
    }

    static void find(Queue<Document> q, PriorityQueue<int[]> pq, int findIndex) {
        int count = 0;
        while(!q.isEmpty()) {
            int[] priorityArr = pq.peek();
            Document document = q.poll();

            if(document.priority == priorityArr[0]) {
                pq.poll();
                count++;
                if(document.index == findIndex) {
                    sb.append(count).append("\n");
                    return;
                }
                if(priorityArr[1] > 1) {
                    priorityArr[1] -= 1;
                    pq.offer(priorityArr);
                }
            } else {
                q.offer(document);
            }
        }
    }

    static int stoi(String value) {
        return Integer.parseInt(value);
    }
}
