package programmers.lv2;
import java.util.*;
public class _131701 {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();

        int[] newElements = new int[elements.length * 2];

        for(int i = 0; i < elements.length; i++){
            newElements[i] = elements[i];
            newElements[i+elements.length] = elements[i];
        }

        for(int i = 1; i <= elements.length; i++){
            for(int j = 0; j < newElements.length; j++){
                int value = 0;
                if(j + i < newElements.length){
                    for(int k = j; k < j + i; k++){
                        value += newElements[k];
                    }
                    set.add(value);
                }
            }
        }

        return set.size();
    }
}
