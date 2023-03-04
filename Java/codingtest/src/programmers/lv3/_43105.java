package programmers.lv3;

public class _43105 {
    static int[] dp;
    static boolean[][] visited;
    public int solution(int[][] triangle) {
        int answer = 0;
        dp = new int[triangle.length];
        visited = new boolean[triangle.length][];
        for(int i = 0; i < triangle.length; i++){
            visited[i] = new boolean[i + 1];
        }
        dfs(triangle, 0, 0, 0, 0);
        answer = dp[triangle.length - 1];
        return answer;
    }

    public void dfs(int[][] triangle, int depth, int start, int end, int value){

        if(depth == triangle.length){
            dp[triangle.length - 1] = Math.max(dp[triangle.length - 1], value);
            return;
        }

        for(int i = start; i <= end; i++){
            visited[depth][i] = true;
            dfs(triangle, depth + 1, i, i + 1, value + triangle[depth][i]);
            visited[depth][i] = false;
        }
    }
}
