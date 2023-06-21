package codingbook.greedy;

import java.io.*;
import java.util.*;
public class Question1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int K = Integer.parseInt(s[2]);

        List<Integer> list = new ArrayList<>();
        String[] value = br.readLine().split(" ");
        for(String val : value){
            list.add(Integer.parseInt(val));
        }

        Collections.sort(list, Collections.reverseOrder());
        int first = list.get(0);
        int second = list.get(1);

        int result = 0;

        while(M > 0){
            for(int i = 0; i < K; i++){
                result += first;
                M -= 1;
                if(M == 0){
                    break;
                }
            }
            result += second;
            M -= 1;
            if(M == 0){
                break;
            }
        }
        System.out.print(result);
    }
}
