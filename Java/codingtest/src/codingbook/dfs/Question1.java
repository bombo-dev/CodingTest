package codingbook.dfs;

import java.io.*;

public class Question1 {
    public static int n, m;
    public static int[][] graph = new int[1000][1000];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] count = br.readLine().split(" ");

        n = Integer.parseInt(count[0]);
        m = Integer.parseInt(count[1]);
        int result = 0;
        for(int i = 0; i < n; i++) {
            String value = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = Character.getNumericValue(value.charAt(j));
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(dfs(i, j)){
                    result += 1;
                }
            }
        }
        System.out.print(result);
    }
    public static boolean dfs(int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= m){
            return false;
        }

        if(graph[x][y] == 0){
            graph[x][y] = 1;
            dfs(x - 1, y);
            dfs(x, y + 1);
            dfs(x + 1, y);
            dfs(x, y - 1);
            return true;
        }
        return false;
    }
}
