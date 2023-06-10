package programmers.lv2;

import java.util.*;

public class _155651 {
    static class Time {
        int startTime;
        int endTime;

        public Time(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public boolean isSmaller(Time t) {
            return t.startTime - (this.endTime + 10) >= 0;
        }
    }

    static int answer = 0;
    public int solution(String[][] book_time) {
        List<Time> times = new ArrayList<>();
        List<Time> result = new ArrayList<>();

        for(int i = 0; i < book_time.length; i++) {
            int startTime = convertTime(book_time[i][0]);
            int endTime = convertTime(book_time[i][1]);

            times.add(new Time(startTime, endTime));
        }

        Collections.sort(times, (a, b) -> {
            return a.startTime - b.startTime;
        });

        calc(times, result);
        return answer;
    }

    public void calc(List<Time> times, List<Time> result) {
        for(int i = 0; i < times.size(); i++) {
            Time time = times.get(i);
            for(int j = 0; j < result.size();) {
                if(result.get(j).isSmaller(time)) {
                    result.remove(j);
                } else {
                    j++;
                }
            }
            result.add(time);
            answer = Math.max(answer, result.size());
        }
    }

    public int convertTime(String time) {
        String[] tt = time.split(":");
        int hour = Integer.parseInt(tt[0]) * 60;
        int minute = Integer.parseInt(tt[1]);

        return hour + minute;
    }
}
