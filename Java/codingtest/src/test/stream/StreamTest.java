package test.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args){
        int[] arr = {3, 5, 7, 2};

        List<Integer> list = new ArrayList<>(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        Collections.sort(list, Collections.reverseOrder());
    }
}
