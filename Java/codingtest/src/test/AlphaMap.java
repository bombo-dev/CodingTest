package test;

import java.util.HashMap;
import java.util.Map;

public class AlphaMap {
    public static void main(String[] args){
        Map<String, Integer> alpha = new HashMap<>();

        for(int i = 0 ; i < (int)'Z' - (int)'A'; i++){
            char val = (char)((int)'A' + i);
            alpha.put(Character.toString(val), Math.min((int)val - 'A', Math.abs((int)val - 'Z')));
        }

        for(Map.Entry<String, Integer> entry : alpha.entrySet()){
            System.out.println("alpha : " + entry.getKey() + "value : " + entry.getValue());
        }
    }
}
