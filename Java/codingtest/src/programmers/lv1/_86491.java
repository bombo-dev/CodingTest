package programmers.lv1;

import java.util.ArrayList;
import java.util.List;

public class _86491 {
    public static void main(String[] args){
        Integer[][] sizes1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        Integer[][] sizes2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        Integer[][] sizes3 = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};

        List<Integer[][]> list = new ArrayList<>();
        list.add(sizes1);
        list.add(sizes2);
        list.add(sizes3);

        for(Integer[][] sizes : list) {
            System.out.println(solution(sizes));
        }
    }

    public static int solution(Integer[][] sizes){
        int width = 0;
        int height = 0;

        for(Integer[] value : sizes){
            width = Math.max(width, Math.max(value[0], value[1]));
            height = Math.max(height, Math.min(value[0], value[1]));
        }
        return width * height;
    }
}
