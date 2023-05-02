package programmers.lv2;

import java.util.*;
public class _132265 {
    static Map<Integer, Integer> aMap = new HashMap<>();
    static Map<Integer, Integer> bMap = new HashMap<>();

    public int solution(int[] topping) {
        init(topping);
        int result = cutting(topping);
        return result;
    }

    void init(int[] topping) {
        for(int value : topping) {
            aMap.put(value, aMap.getOrDefault(value, 0) + 1);
        }
    }

    int cutting(int[] topping) {
        int result = 0;
        for(int i = topping.length - 1; i >= 0; i--) {
            int find = topping[i];
            aMap.put(find, aMap.get(find) - 1);
            bMap.put(find, bMap.getOrDefault(find, 0) + 1);

            if(aMap.get(find) == 0) {
                aMap.remove(find);
            }

            if(aMap.size() == bMap.size())
                result++;
        }

        return result;
    }
}
