package baekjoon;

import java.io.*;
import java.util.*;

class Pair {
    int height;
    int cnt;

    Pair(int height, int cnt){
        this.height = height;
        this.cnt = cnt;
    }
}

// 합이 int 의 범위를 넘어갈 수 있다는 것을 기억하자.
// 웬만하면 결과 값 선언은 long 타입으로 하는 것이 좋을 것 같다.
public class _3015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Pair> stack = new Stack<>();
        long ans = 0;
        for(int i = 0; i < N; i++){
            int value = Integer.parseInt(br.readLine());
            Pair p = new Pair(value, 1);

            // 내림 차순을 유지해야 한다. 모노 스택
            while(!stack.isEmpty() && stack.peek().height <= value){
                Pair out = stack.pop();
                ans += out.cnt;

                if(out.height == value){
                    p.cnt = out.cnt + 1;
                }
            }

            if(!stack.isEmpty()){
                ans++;
            }
            stack.push(p);
        }
        System.out.print(ans);
    }
}
