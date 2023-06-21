package codingbook.greedy.practical;

import java.io.*;
import java.util.*;
public class Practical2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String init = br.readLine();
        Integer[] value = new Integer[init.length()];

        for(int i = 0; i < init.length(); i++){
            value[i] = Character.getNumericValue(init.charAt(i));
        }

        Arrays.sort(value, Collections.reverseOrder());
        int result = value[0];

        for(int i = 1; i < value.length; i++){
            if(value[i] != 0){
                result *= value[i];
            } else{
                result += value[i];
            }
        }
        System.out.print(result);
    }
}
