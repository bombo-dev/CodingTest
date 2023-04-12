package baekjoon;
import java.util.*;
public class _5648 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Long[] arr = new Long[N];

        for(int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(sc.next());
            sb.reverse();
            arr[i] = Long.parseLong(sb.toString());
        }

        Arrays.sort(arr);

        for(int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }
}
