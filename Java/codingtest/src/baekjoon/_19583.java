package baekjoon;

import java.io.*;
import java.util.*;
public class _19583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String startTime = st.nextToken();
        int startHour = Integer.parseInt(startTime.substring(0, 2));
        int startMinute = Integer.parseInt(startTime.substring(3));
        String endTime = st.nextToken();
        int endHour = Integer.parseInt(endTime.substring(0, 2));
        int endMinute = Integer.parseInt(endTime.substring(3));
        String finishTime = st.nextToken();
        int finishHour = Integer.parseInt(finishTime.substring(0, 2));
        int finishMinute = Integer.parseInt(finishTime.substring(3));

        int internalTime = (finishHour * 60 + finishMinute) - (endHour * 60 + endMinute);
        int count = 0;

        System.out.println(internalTime);
        Map<String, String> map = new HashMap<>();

        while(true) {
            String value = br.readLine();
            if(value.equals("")) {
                break;
            }
            String[] arr = value.split(" ");
            String log = arr[0];
            String id = arr[1];

            int hour = Integer.parseInt(log.substring(0, 2));
            int minute = Integer.parseInt(log.substring(3));

            if(hour > finishHour) {
                continue;
            } else if (hour == finishHour && minute > finishMinute) {
                continue;
            }

            if(hour < startHour) {
                if(!map.containsKey(id)) {
                    map.put(id, log);
                }
            } else if(hour == startHour && minute <= startMinute) {
                if(!map.containsKey(id)) {
                    map.put(id, log);
                }
            }

            if((finishHour * 60 + finishMinute) - (hour * 60 + minute) <= internalTime) {
                if(map.containsKey(id)) {
                    count++;
                    map.remove(id);
                }
            }
        }
        System.out.print(count);
    }
}
