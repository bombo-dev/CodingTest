package baekjoon;

import java.io.*;
import java.util.*;

class Top {
    int index;
    int height;

    Top(int index, int height) {
        this.index = index;
        this.height = height;
    }
}


/**
 * 시간 복잡도에 대해서 고려해야했다. 우선 순위를 살피던 중 만약 이후에 들어올 수가 기존 값 보다 작으면 기존 값은 참고 할 필요가 없다. 큰 값이 대체하기 때문이다.
 * 위치에 꽂혀서 클래스를 선언해서 index 를 정해줄 생각을 하지 않은 것이 시간이 오래 걸린 큰 요인이었다.
 * 클래스를 사용하더라도 시간 복잡도에 맞게 확실히 시간을 줄일 수 있다면 주저하지 말고 사용 할 것.
 */
public class _2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Stack<Top> stack = new Stack<>();
        // 스택에 값 집어넣기
        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());
            if (stack.isEmpty()) {
                stack.push(new Top(i, height));
                sb.append(0 + " ");
            } else {
                while (!stack.isEmpty()) {
                    if (stack.peek().height >= height) {
                        sb.append(stack.peek().index + " ");
                        stack.push(new Top(i, height));
                        break;
                    } else {
                        stack.pop();
                    }
                }

                if (stack.isEmpty()) {
                    sb.append(0 + " ");
                    stack.push(new Top(i, height));
                }
            }
        }
        System.out.println(sb.toString());
    }
}
