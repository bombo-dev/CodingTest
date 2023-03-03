package programmers.lv2;

public class _87946 {
    static boolean[] visited;
    static int answer = -1;
    public int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];
        backTracking(k, 0, dungeons);

        return answer;
    }

    public void backTracking(int k, int cnt, int[][] dungeons){
        answer = Math.max(answer, cnt);

        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i] && dungeons[i][0] <= k){
                visited[i] = true;
                backTracking(k - dungeons[i][1], cnt + 1, dungeons);
                visited[i] = false;
            }
        }
    }
}
