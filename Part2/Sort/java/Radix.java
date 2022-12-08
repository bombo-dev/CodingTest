import java.util.*;
import java.util.stream.*;

public class Radix {
    public static Integer[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};

    public static void main(String[] args){
        // primitive 타입
//        List<Integer> list = new ArrayList<>(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        int max = Collections.max(list);

        Arrays.sort(arr, Collections.reverseOrder());

        int[] radix = new int[max + 1];

        for(int val : arr){
            radix[val] += 1;
        }

        for(int i = 0; i < radix.length; i++){
            for(int j = 0; j < radix[i]; j++){
                System.out.print(i + " ");
            }
        }
    }
}
