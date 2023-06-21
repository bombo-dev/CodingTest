package test.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class rangeIntStream {
    public static void main(String[] args){
        IntStream stream1 = IntStream.range(1, 4);
        stream1.forEach(e -> System.out.print(e + " "));

        IntStream stream2 = IntStream.rangeClosed(1, 4);
        stream2.forEach(e -> System.out.print(e + " "));

        Stream stream = Stream.iterate(2, n -> n + 2);
        stream.forEach(e -> System.out.print(e + " "));
    }
}
