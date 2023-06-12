package study._1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Integer[] value = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).sorted().toArray(Integer[]::new);
        Integer[] value2 = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).sorted(Comparator.reverseOrder()).toArray(Integer[]::new);
        
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += value[i] * value2[i];
        }

        System.out.print(sum);
    }
}
