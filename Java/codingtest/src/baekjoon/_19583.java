package baekjoon;

import java.io.*;
import java.util.*;
public class _19583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String startTime = st.nextToken();
        String endTime = st.nextToken();
        String finishTime = st.nextToken();

        int count = 0;

        Map<String, String> map = new HashMap<>();

        while (true) {
            String value = br.readLine();
            if (value == null || value.equals("")) {
                break;
            }
            String[] arr = value.split(" ");
            String log = arr[0];
            String id = arr[1];

            if(startTime.compareTo(log) >= 0) {
                if(!map.containsKey(id)) {
                    map.put(id, log);
                }
            }

            if(finishTime.compareTo(log) < 0) {
                continue;
            }

            if(endTime.compareTo(log) <= 0 && finishTime.compareTo(log) >= 0) {
                if(map.containsKey(id)) {
                    count++;
                    map.remove(id);
                }
            }
        }
        System.out.print(count);
    }
}
