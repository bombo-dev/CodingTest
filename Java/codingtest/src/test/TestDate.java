package test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestDate {

    public static void main(String[] args){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 0, 0));
    }
}
