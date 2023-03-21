package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class _2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] muz = new int[8];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int start = Integer.parseInt(st.nextToken());

        if(start == 1){
            while(st.hasMoreElements()){
                int next = Integer.parseInt(st.nextToken());
                if(Math.abs(start - next) != 1) {
                    System.out.print("mixed");
                    return;
                }
                start = next;
            }
            System.out.print("ascending");
            return;
        } else {
            while(st.hasMoreElements()){
                int next = Integer.parseInt(st.nextToken());
                if(Math.abs(start - next) != 1) {
                    System.out.print("mixed");
                    return;
                }
                start = next;
            }
            System.out.print("descending");
            return;
        }
    }
}
