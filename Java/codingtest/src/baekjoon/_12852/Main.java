package baekjoon._12852;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] dp = new int[(int) 1e7];
    static final int INF = (int) 1e9;
    static int find;

    public static void main(String[] args) throws IOException {
        find = Integer.parseInt(br.readLine());
        play();
        find();
        System.out.print(sb);
    }

    static void play() {
        Arrays.fill(dp, INF);
        dp[1] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);

        while (!q.isEmpty()) {
            int index = q.poll();

            if (index == find)
                return;

            if(index > find)
                continue;

            if (dp[index * 3] > dp[index] + 1) {
                q.offer(index * 3);
                dp[index * 3] = dp[index] + 1;
            }

            if (dp[index * 2] > dp[index] + 1) {
                q.offer(index * 2);
                dp[index * 2] = dp[index] + 1;
            }

            if (dp[index + 1] > dp[index] + 1) {
                q.offer(index + 1);
                dp[index + 1] = dp[index] + 1;
            }
        }
    }

    static void find() {
        sb.append(dp[find]).append("\n");

        int findValue = find;

        while (findValue != 1) {
            sb.append(findValue).append(" ");
            int value = dp[findValue];

            if (findValue >= 3 && findValue % 3 == 0 && dp[findValue / 3] == value - 1) {
                findValue /= 3;
            } else if (findValue >= 2 && findValue % 2 == 0 && dp[findValue / 2] == value - 1) {
                findValue /= 2;
            } else {
                findValue -= 1;
            }
        }
        sb.append(1);
    }
}
