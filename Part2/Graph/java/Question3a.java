import java.io.*;
import java.util.*;

public class Question3a {

    public static List<ArrayList<Integer>> graph = new ArrayList<>();
    public static int[] inDegree = new int[501];
    public static int[] time = new int[501];
    public static int[] result = new int[501];

    public static void topology(int length){
        result = time.clone();
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for(int i = 1; i < length; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
            while(!q.isEmpty()){
                int now = q.poll();
                for(int node : graph.get(now)){
                    inDegree[node] -= 1;
                    result[node] = Math.max(result[node], result[now] + time[node]);
                    if(inDegree[node] == 0)
                        q.offer(node);
                }
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
                    graph.get(Integer.parseInt(value[j])).add(i);
                    inDegree[i] += 1;
                }
            }
        }
        topology(v + 1);
        for(int i = 1; i < v + 1; i++){
            System.out.println(result[i]);
        }
    }
}
