package baekjoon._1620;

import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static HashMap<Integer, String> numberToNameMap = new HashMap<>();
    static HashMap<String, Integer> nameToNumberMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        init();
        play();
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++) {
            String name = br.readLine();
            numberToNameMap.put(i, name);
            nameToNumberMap.put(name, i);
        }
    }

    static void play() throws IOException {
        for(int i = 0; i < M; i++) {
            String value = br.readLine();
            if(isDigit(value))
                System.out.println(numberToNameMap.get(Integer.parseInt(value)));
            else
                System.out.println(nameToNumberMap.get(value));
        }
    }

    static boolean isDigit(String value) {
        for(int i = 0; i < value.length(); i++) {
            if(!Character.isDigit(value.charAt(i)))
                return false;
        }
        return true;
    }
}
