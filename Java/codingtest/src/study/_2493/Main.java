package study._2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Tower {
    int index;
    int height;
    int result;

    Tower(int index, int height) {
        this.index = index;
        this.height = height;
        result = 0;
    }

    public void setResult(int index) {
        this.result = index;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static List<Tower> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        Deque<Tower> originStack = new ArrayDeque<>();
        Deque<Tower> tempStack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            originStack.push(new Tower(i + 1, Integer.parseInt(st.nextToken())));
        }

        solve(originStack, tempStack);
        results.sort((a, b) -> a.index - b.index);
        StringBuilder sb = new StringBuilder();
        for (Tower tower : results) {
            sb.append(tower.result).append(" ");
        }
        System.out.print(sb);
    }

    static void solve(Deque<Tower> originStack, Deque<Tower> tempStack) {
        while (!originStack.isEmpty()) {
            while (!tempStack.isEmpty() && originStack.peek().height >= tempStack.peek().height) {
                Tower out = tempStack.pop();
                out.setResult(originStack.peek().index);
                results.add(out);
            }
            tempStack.push(originStack.pop());
        }

        while (!tempStack.isEmpty()) {
            results.add(tempStack.pop());
        }
    }
}
