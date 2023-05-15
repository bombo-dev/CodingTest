package programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class _176963 {
    static Map<String, Integer> point = new HashMap<>();
    static int[] result;
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        init(name, yearning, photo);
        calc(photo);

        return result;
    }

    public void init(String[] name, int[] yearning, String[][] photo) {
        for(int i = 0; i < name.length; i++) {
            point.put(name[i], yearning[i]);
        }

        result = new int[photo.length];
    }

    public void calc(String[][] photo) {
        for(int i = 0; i < photo.length; i++) {
            int count = 0;
            for(int j = 0; j < photo[i].length; j++) {
                String name = photo[i][j];
                if(point.containsKey(name))
                    count += point.get(name);
            }
            result[i] = count;
        }
    }
}
