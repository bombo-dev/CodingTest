package test.stream;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.*;

public class Stream {

    public static void lambda(){

    }

    public static void streamMap(){
        String[] arr = {"I study hard", "You study Java", "I am hungry"};
        Arrays.stream(arr)
                .flatMap(s -> java.util.stream.Stream.of(s.split(" ")))
                .forEach(s -> System.out.println(s + " "));
    }
    public static void streamLimitAndSkip() {
        IntStream stream1 = IntStream.range(0, 10);
        IntStream stream2 = IntStream.range(0, 10);
        IntStream stream3 = IntStream.range(0, 10);
        IntStream stream4 = IntStream.range(0, 10);
        stream1.skip(4).forEach(n -> System.out.print(n + " "));
        System.out.println();

        stream2.limit(5).forEach(n -> System.out.print(n + " "));
        System.out.println();

        stream3.skip(3).limit(5).forEach(n -> System.out.print(n + " "));
        System.out.println();

        stream4.limit(5).skip(2).forEach(n -> System.out.print(n + " "));
        System.out.println();

    }



    public static void main(String[] args){
        streamMap();

    }
}
