package baekjoon._11723;

import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> list = new ArrayList<>(20);

    public static void main(String[] args) throws IOException {
        N = stoi(br.readLine());
        solve();
        System.out.print(sb);
    }

    static void solve() throws IOException {
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            Integer value = 0;
            if(st.hasMoreElements()){
                value = stoi(st.nextToken());
            }
            calc(command, value);
        }
    }

    static void calc(String command, Integer value) {
        switch(command) {
            case "add":
                if(!list.contains(value))
                    list.add(value);
                break;

            case "remove":
                if(list.contains(value))
                    list.remove(value);
                break;

            case "check":
                if(list.contains(value))
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
                break;

            case "toggle":
                if(!list.contains(value)){
                    list.add(value);
                } else {
                    list.remove(value);
                }
                break;

            case "all":
                list = new ArrayList<>(20);
                for(int i = 1; i <= 20; i++) {
                    list.add(i);
                }
                break;

            case "empty":
                list = new ArrayList<>(20);
                break;
        }
    }

    static int stoi(String value) {
        return Integer.parseInt(value);
    }
}
