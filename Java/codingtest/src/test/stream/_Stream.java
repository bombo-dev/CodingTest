package test.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.reverseOrder;

public class _Stream {

    public static void streamOf(){
        Stream<String> stream = Stream.of("code", "chacha");
        stream.forEach(s -> System.out.println(s));

        int[] score = {1, 2, 3, 1, 2, 3, 1};
        List<Integer> list = new ArrayList<>();
        list = Arrays.stream(score).boxed().collect(Collectors.toList());
        list.sort(reverseOrder());

        for(int i = 0; i <list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args){
        streamOf();
    }
}
