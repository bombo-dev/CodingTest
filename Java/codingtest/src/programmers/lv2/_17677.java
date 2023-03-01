package programmers.lv2;
import java.util.*;
public class _17677 {
    public int solution(String str1, String str2) {
        int answer = 0;

        ArrayList<String> str1_list = new ArrayList<>();
        ArrayList<String> str2_list = new ArrayList<>();
        HashMap<String, Integer> str1_map = new HashMap<>();
        HashMap<String, Integer> str2_map = new HashMap<>();

        for(int i = 0; i < str1.length() - 1; i++){
            char a = str1.charAt(i);
            char b = str1.charAt(i + 1);
            String value = str1.substring(i, i + 2);

            if(Character.isLetter(a) && Character.isLetter(b)){
                str1_list.add(value.toLowerCase());
            }
        }

        for(int i = 0; i < str2.length() - 1; i++){
            char a = str2.charAt(i);
            char b = str2.charAt(i + 1);
            String value = str2.substring(i, i + 2);

            if(Character.isLetter(a) && Character.isLetter(b)){
                str2_list.add(value.toLowerCase());
            }
        }

        for(int i = 0; i < str1_list.size(); i++){
            String key = str1_list.get(i);
            str1_map.put(key, str1_map.getOrDefault(key, 0) + 1);
        }

        for(int i = 0; i < str2_list.size(); i++){
            String key = str2_list.get(i);
            str2_map.put(key, str2_map.getOrDefault(key, 0) + 1);
        }

        HashMap<String, Integer> intersection = new HashMap<>();
        HashMap<String, Integer> union = new HashMap<>();

        for(String key: str1_map.keySet()){
            Integer str1_value = str1_map.get(key);
            Integer str2_value = str2_map.get(key);

            if(str1_value != null && str2_value != null){
                intersection.put(key, Math.min(str1_value, str2_value));
                union.put(key, Math.max(str1_value, str2_value));
            } else if (str1_value != null && str2_value == null){
                union.put(key, str1_value);
            } else {
                union.put(key, str2_value);
            }
        }

        for(String key : str2_map.keySet()){
            Integer str2_value = str2_map.get(key);

            if(!union.containsKey(key)){
                union.put(key, str2_value);
            }
        }

        int intersectionValue = 0;
        int unionValue = 0;

        for(String key : intersection.keySet()){
            intersectionValue += intersection.get(key);
        }

        for(String key : union.keySet()){
            unionValue += union.get(key);
        }

        if(intersectionValue == 0 && unionValue == 0){
            answer = 1 * 65536;
        } else {
            double result = (double)intersectionValue / (double)unionValue;
            answer = (int)(result * 65536);
        }


        return answer;
    }
}
