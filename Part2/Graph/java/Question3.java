import java.io.*;
import java.util.*;

class Subject implements Comparable<Subject> {
    private int node;
    private int time;

    public Subject(int node, int time) {
        this.node = node;
        this.time = time;
    }

    public int getNode() {
        return node;
    }

    public int getTime() {
        return time;
    }

    @Override
    public int compareTo(Subject subject) {
        return this.time - subject.time;
    }
}

public class Question3 {

    public static PriorityQueue<Subject> pq = new PriorityQueue<>();
    public static List<ArrayList<Integer>> graph = new ArrayList<>();
    public static int[] inDegree = new int[501];
    public static int[] time = new int[501];
    public static int[] result = new int[501];

    public static void topology(int length){
        result = time.clone();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 1; i < length + 1; i++){
            if(inDegree[i] == 0){
                pq.offer(new Subject(i, time[i]));
            }
        }
        for(int i = 0; i < pq.size(); i++){
            q.offer(pq.poll().getNode());
        }
        while(!q.isEmpty()){
            int now = q.poll();
            for(int node : graph.get(now)){
                inDegree[node] -= 1;
                result[node] = Math.max(result[node], time[node] + result[now]);
                if(inDegree[node] == 0){
                    pq.offer(new Subject(node, time[node]));
                }
            }
            for(int i = 0; i < pq.size(); i++){
                q.offer(pq.poll().getNode());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        for(int i = 0; i < v + 1; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 1; i < v + 1; i++){
            String[] value = br.readLine().split(" ");
            if(value.length < 3){
                time[i] = Integer.parseInt(value[0]);
            } else {
                time[i] = Integer.parseInt(value[0]);
                for(int j = 1; j < value.length - 1; j++){
                    inDegree[i] += 1;
                    int node = Integer.parseInt(value[j]);
                    graph.get(node).add(i);
                }
            }
        }
        topology(v);
        for(int i = 1; i < v + 1; i++){
            System.out.println(result[i]);
        }
    }
}
