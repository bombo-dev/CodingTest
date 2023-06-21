package programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class _148652 {
    public static void main(String[] args){
        long answer = 0;
        String s = "1";
        int n = 3;
        long l = 4;
        long r = 17;

        for(int i = 1; i < n; i++){
            for(int j = 0; j < Math.pow(5, i + 1); j += 5){
                char[] value = s.toCharArray();
                if(value[j] == '1'){
                    s = s.substring(0, j) + "11011" + s.substring(j, s.length());
                    System.out.println("canto : " + s);
                }
                else{
                    s = s.substring(0, j) + "00000" + s.substring(j, s.length());
                    System.out.println("canto : " + s);
                }
            }
        }

    }
}
