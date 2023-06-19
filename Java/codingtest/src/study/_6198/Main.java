package study._6198;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long total = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> originStack = new ArrayDeque<>();

        solve(originStack);
        System.out.print(total);
    }

    static void solve(ArrayDeque<Integer> originStack) throws IOException {
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());

            while (!originStack.isEmpty()) {
                if (height >= originStack.peek()) {
                    originStack.pop();
                } else {
                    break;
                }
            }
            total += originStack.size();
            originStack.push(height);
        }
    }
}
