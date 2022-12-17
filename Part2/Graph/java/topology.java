import java.io.*;
import java.util.*;
public class Topology {

    public static int[] inDegree = new int[1000001];
    public static List<ArrayList<Integer>> graph = new ArrayList<>();

    public static void topology(int length){
        StringBuilder sb = new StringBuilder(); // 알고리즘 수행 결과를 담을 StringBuilder 혹은 리스트 사용 가능
        ArrayDeque<Integer> q = new ArrayDeque<>(); // 큐 기능을 위한 Deque 사용

        // 처음 시작할 때는 진입 차수가 0인 노드를 큐에 삽입
        for(int i = 1; i < length; i++){
            if(inDegree[i] == 0)
                q.offer(i);
        }

        // 큐가 빌 때까지 반복
        while(!q.isEmpty()){
            int now = q.pollFirst();
            sb.append(now + " ");
            for(int node : graph.get(now)){
                inDegree[node] -= 1;
                // 새롭게 진입 차수가 0이 되는 노드를 큐에 삽입
                if(inDegree[node] == 0){
                    q.offer(node);
                }
            }
        }
        // 위상 정렬을 수행한 결과 출력
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 노드의 개수와 간선의 개수를 입력받기
        String[] init = br.readLine().split(" ");
        int v = Integer.parseInt(init[0]);
        int e = Integer.parseInt(init[1]);

        // 모든 노드에 대한 진입 차수를 0으로 초기화
        for(int i = 1; i < v + 1; i++){
            inDegree[i] = 0;
        }

        // 각 노드에 연결된 간선 정보를 담기 위한 연결 리스트 초기화
        for(int i = 0; i < v + 1; i++){
            graph.add(new ArrayList<Integer>());
        }

        // 방향 그래프의 모든 간선 정보를 입력 받기
        for(int i = 0; i < e; i++){
            String[] value = br.readLine().split(" ");
            int start = Integer.parseInt(value[0]);
            int end = Integer.parseInt(value[1]);
            // 노드 start 에서 노드 end 로 이동
            graph.get(start).add(end);
            // end 의 진입차수 1 증가
            inDegree[end] += 1;
        }
        topology(v + 1);
    }
}
