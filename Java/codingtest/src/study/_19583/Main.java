package study._19583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


// 개강 총회를 시작할 때까지 채팅을 쳐야함.
// 개강 총회 끝 ~ 스트리밍이 끝날 때까지
// 개강 총회 스트리밍이 끝난 이후로 남겨진건 퇴장으로 간주 X
public class Main {
    static int[] timeArr = new int[3];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Set<String> set = new HashSet<>();
    static Set<String> resultSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        init();
        solve();
        System.out.print(resultSet.size());
    }

    private static void solve() throws IOException {
        while (true) {
            String value = br.readLine();
            if (value == null || value.equals("")) {
                return;
            }
            String[] chat = value.split(" ");
            String time = chat[0];
            String name = chat[1];

            String[] splitTime = time.split(":");
            int convertTime = Integer.parseInt(splitTime[0]) * 60 + Integer.parseInt(splitTime[1]);
            if (convertTime <= timeArr[0]) {
                set.add(name);
            } else if (convertTime >= timeArr[1] && convertTime <= timeArr[2]) {
                if (set.contains(name)) {
                    resultSet.add(name);
                }
            }
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            String time = st.nextToken();
            String[] split = time.split(":");
            timeArr[i] = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
        }
    }
}
