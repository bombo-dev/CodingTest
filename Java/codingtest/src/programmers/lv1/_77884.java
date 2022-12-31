package programmers.lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 약수의 개수와 덧셈
public class _77884 {
    public static void main(String[] args){
        solution(13, 17);
    }

    public static void solution(int left, int right){
        for(int i = left; i <= right; i++){
            remainderCount(i);
            remainderList(i);
        }
    }

    public static void remainderCount(int value){
        int result = 0;
        for(int i = 1; i <= Math.sqrt(value); i++){
            if(value % i == 0){
                result += 2;
            }
        }

        if(Math.sqrt(value) % value == 0){
            result -= 1;
        }
        System.out.println(value + "의 약수의 개수  : " + result);
    }

    public static void remainderList(int value){
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= Math.sqrt(value); i++){
            if(value % i == 0){
                list.add(i);
                list.add(value / i);
            }
        }

        if(value % Math.sqrt(value) == 0)
            list.remove(list.size() - 1);

        Collections.sort(list);
        System.out.print("[");
        for(int val : list){
            System.out.print(val + " ");
        }
        System.out.print("]");
        System.out.println();
    }
}
