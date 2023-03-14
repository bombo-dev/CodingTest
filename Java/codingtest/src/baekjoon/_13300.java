package baekjoon;

import java.io.*;
import java.util.*;

public class _13300 {
    static final int WOMAN = 0;
    static final int MAN = 1;
    public static void main(String[] args) throws IOException {

        int ans = 0;

        // 성별, 학년
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] womanArr = new int[7];
        int[] manArr = new int[7];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            if(gender == WOMAN)
                womanArr[grade]++;
            else
                manArr[grade]++;
        }

        int index = 1;
        while(index < 7){
            while(manArr[index] > 0){
                manArr[index] -= K;
                ans++;
            }

            while(womanArr[index] > 0){
                womanArr[index] -= K;
                ans++;
            }

            if(manArr[index] <= 0 && womanArr[index] <= 0)
                index++;
        }

        System.out.println(ans);
    }
}
