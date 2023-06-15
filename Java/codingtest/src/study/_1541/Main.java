package study._1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;

        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                sb.append(ch);
                continue;
            }

            if (flag) {
                if (q.isEmpty()) {
                    q.offer(Integer.parseInt(sb.toString()));
                    sb.setLength(0);
                } else {
                    q.offer(q.poll() + Integer.parseInt(sb.toString()));
                    sb.setLength(0);
                }
            }

            if (!flag && ch == '-') {
                list.add(Integer.parseInt(sb.toString()));
                sb.setLength(0);
                flag = true;
            } else if (!flag && ch == '+') {
                list.add(Integer.parseInt(sb.toString()));
                sb.setLength(0);
            }
        }

        if (flag) {
            if (!q.isEmpty()) {
                list.add(-(q.poll() + Integer.parseInt(sb.toString())));
            } else {
                list.add(-(Integer.parseInt(sb.toString())));
            }
        } else {
            list.add(Integer.parseInt(sb.toString()));
        }


        int sum = 0;
        for (int value : list) {
            sum += value;
        }
        System.out.print(sum);
    }
}
