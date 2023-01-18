package programmers.lv1;

import java.time.*;
import java.util.*;
import java.time.format.*;

public class _12901 {

    public String solution(int a, int b) {
        String answer = "";

        LocalDate date = LocalDate.of(2016, a, b);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        answer = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US);
        answer = answer.toUpperCase();


        return answer;
    }

    public static String getDayName(int a, int b) {
        String answer = "";
        String[] day = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
        int[] date = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int allDate = 0;
        for (int i = 0; i < a - 1; i++) {
            allDate += date[i];
        }
        allDate += (b - 1);
        answer = day[allDate % 7];

        return answer;
    }
    public static void main(String[] args)
    {
        int a=5, b=24;
        System.out.println(_12901.getDayName(a,b));
    }
}
