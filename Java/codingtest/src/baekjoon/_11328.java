package baekjoon;

import java.io.*;
import java.util.*;
public class _11328 {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] alpha;
        boolean check;
        for(int i = 0; i < N; i++){
            check = false;
            alpha = new int[130];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String one = st.nextToken();
            String two = st.nextToken();

            if(one.length() != two.length()){
                System.out.println("Impossible");
                continue;
            }

            for(int j = 0; j < one.length(); j++){
                alpha[one.charAt(j)]++;
            }

            for(int j = 0; j < two.length(); j++){
                if(alpha[two.charAt(j)] == 0) {
                    check = true;
                    break;
                } else {
                    alpha[two.charAt(j)]--;
                }
            }
            if(check)
                System.out.println("Impossible");
            else
                System.out.println("Possible");
        }
    }
}
