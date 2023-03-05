package programmers.lv3;

import java.util.*;
public class _12938 {
    public static boolean[] visited;
    public static int max;
    public static int[] answer;
    public static ArrayList<Integer> list = new ArrayList<>();

    public int[] solution(int n, int s) {
        answer = new int[n];
        visited = new boolean[s + 1];
        max = 0;
        backTracking(1, 0, n, 0, s);

        if(max == 0){
            return new int[]{-1};
        }

        return answer;
    }

    public void backTracking(int start, int depth, int lastDepth, int sum, int find){
        if(sum > find){
            return;
        }


        if(depth == lastDepth && sum < find){
            return;
        }

        if(depth == lastDepth && sum == find){

            int multi = 1;
            Queue<Integer> q = new LinkedList<>();
            for(int value : list){
                multi *= value;
                q.offer(value);
            }
            System.out.println();
            if(max < multi){
                max = multi;
                int index = 0;
                while(!q.isEmpty()){
                    answer[index] = q.poll();
                    index++;
                }
            }
            return;
        }



        for(int i = start; i <= find; i++){
            visited[i] = true;
            list.add(i);
            backTracking(i, depth + 1, lastDepth, sum + i, find);
            list.remove(depth);
            visited[i] = false;
        }
    }
}
