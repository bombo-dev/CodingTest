package baekjoon;
import java.io.*;
import java.util.*;

public class _15688 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] count = new int[2000001];
        for(int i = 0; i < N; i++) {
            int index = Integer.parseInt(br.readLine());
            index += 1000000;
            count[index]++;
        }

        for(int i = 0; i < count.length; i++){
            if(count[i] != 0) {
                for(int j = 0; j < count[i]; j++){
                    sb.append(i - 1000000).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
