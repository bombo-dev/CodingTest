package input;

import java.io.*;

public class CodeUp1097 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] baduk = new int[19][19];
        for (int i = 0; i < 19; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                baduk[i][j] = Integer.parseInt(s[j]);
            }
        }
        int n = Integer.parseInt(br.readLine().trim());
        for (int count = 0; count < n; count++) {
            String[] coordinate = br.readLine().split(" ");
            int x = Integer.parseInt(coordinate[0]);
            int y = Integer.parseInt(coordinate[1]);

            for (int cool = 0; cool < 19; cool++) {
                baduk[x][cool] = (baduk[x][cool] == 0) ? 1 : 0;
                baduk[cool][y] = baduk[cool][y] == 0 ? 1 : 0;
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                System.out.print(baduk[i][j] + " ");
            }
            System.out.println();
        }

    }
}