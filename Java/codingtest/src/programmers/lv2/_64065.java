package programmers.lv2;
import java.util.*;

public class _64065 {
    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        sb.append(s);

        sb.delete(0, 1);
        sb.delete(sb.length() - 2, sb.length() - 1);

        int startIndex = 0;
        int endIndex = 0;
        boolean checkIndex = false;

        for(int i = 0; i < sb.length(); i++){
            checkIndex = false;
            if(sb.charAt(i) == '{'){
                startIndex = i;
            } else if(sb.charAt(i) == '}'){
                endIndex = i;
                checkIndex = true;
            }

            if(checkIndex){
                String value = sb.substring(startIndex, endIndex + 1);
                list.add(value);
            }
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String a1, String a2){
                return a1.length() - a2.length();
            }
        });

        ArrayList<Integer> resultList = new ArrayList<>();

        for(String value : list){
            value = value.substring(1, value.length() - 1);
            String[] newValue = value.split(",");
            for(String val : newValue){
                if(!resultList.contains(Integer.parseInt(val))){
                    resultList.add(Integer.parseInt(val));
                }
            }
        }

        int[] answer = new int[resultList.size()];
        for(int i = 0; i < resultList.size(); i++){
            answer[i] = resultList.get(i);
        }

    }
}
