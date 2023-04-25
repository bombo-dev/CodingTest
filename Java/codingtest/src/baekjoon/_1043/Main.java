package baekjoon._1043;

import java.io.*;
import java.util.*;

public class Main {
    static int N; // 사람
    static int M; // 파티 수
    static int initKnown; // 아는 사람 초기값
    static ArrayList<ArrayList<Integer>> party = new ArrayList<>(); // 파티 가변 저장
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited; // 아는 사람 방문 처리
    static Set<Integer> known = new HashSet<>(); // 아는 사람 셋
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        init();
        link();
        find();
        System.out.print(result);
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = stoi(st.nextToken());
        visited = new boolean[N + 1];
        M = stoi(st.nextToken());
        result = M;
        setKnown();
        dataSave();
    }

    private static void setKnown() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        initKnown = stoi(st.nextToken());


        for (int i = 0; i < initKnown; i++) {
            known.add(stoi(st.nextToken()));
        }
    }

    static void dataSave() throws IOException {
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            party.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int personCount = stoi(st.nextToken());
            int[] link = new int[personCount];

            for (int j = 0; j < personCount; j++) {
                int person = stoi(st.nextToken());
                party.get(i).add(person);
                link[j] = person;
            }

            for (int j = 0; j < personCount - 1; j++) {
                for (int k = j + 1; k < personCount; k++) {
                    int from = link[j];
                    int to = link[k];
                    list.get(from).add(to);
                    list.get(to).add(from);
                }
            }
        }
    }

    static void link() {
        ArrayList<Integer> kn = new ArrayList<>();
        for (int value : known) {
            kn.add(value);
        }

        if (!kn.isEmpty()) {
            for (int value : kn) {
                if (!visited[value])
                    union(value);
            }
        }
    }

    static void union(int start) {
        boolean isKnown = false;
        visited[start] = true;
        if (known.contains(start))
            isKnown = true;

        for (int end : list.get(start)) {
            if (!visited[end]) {
                if (isKnown) {
                    known.add(end);
                }
                union(end);
            }
        }
    }

    static void find() {
        if (known.isEmpty())
            return;

        for (int i = 0; i < M; i++) {
            boolean check = false;
            for (int value : party.get(i)) {
                if (known.contains(value)) {
                    check = true;
                    break;
                }
            }
            if (check)
                result--;
        }
    }

    static int stoi(String value) {
        return Integer.parseInt(value);
    }
}
