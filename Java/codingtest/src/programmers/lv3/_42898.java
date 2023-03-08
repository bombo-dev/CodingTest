package programmers.lv3;

public class _42898 {
    static int[][] graph;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        // X, Y 대칭
        graph = new int[n][m];
        for(int[] val : puddles){
            graph[val[1] - 1][val[0] - 1] = -1;
        }
        graph[0][0] = 1;

        for(int i = 1; i < m; i++){
            if(graph[0][i] == -1)
                continue;
            if(graph[0][i - 1] == -1)
                graph[0][i] = -1;
            else
                graph[0][i] = 1;
        }

        for(int i = 1; i < n; i++){
            if(graph[i][0] == -1)
                continue;

            if(graph[i - 1][0] == -1)
                graph[i][0] = -1;
            else
                graph[i][0] = 1;
        }


        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(graph[i][j] == -1)
                    continue;
                else{
                    if(graph[i - 1][j] == -1 && graph[i][j - 1] != -1)
                        graph[i][j] = graph[i][j - 1];
                    else if(graph[i - 1][j] != -1 && graph[i][j - 1] == -1)
                        graph[i][j] = graph[i - 1][j];
                    else if(graph[i - 1][j] != -1 && graph[i][j - 1] != -1)
                        graph[i][j] = (graph[i - 1][j] + graph[i][j - 1]) % 1000000007;
                    else
                        graph[i][j] = -1;
                }
            }
        }

        answer = graph[n - 1][m - 1];

        if(answer == -1)
            return 0;

        return answer;
    }
}
