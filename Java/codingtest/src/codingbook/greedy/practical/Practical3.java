package codingbook.greedy.practical;

import java.io.*;

public class Practical3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String init = br.readLine();
        int[] value = new int[init.length()];

        int zeroCount = 0;
        int oneCount = 0;

        for (int i = 0; i < init.length(); i++) {
            value[i] = Character.getNumericValue(init.charAt(i));
        }

        if(value[0] == 0){
            zeroCount += 1;
        } else{
            oneCount += 1;
        }

        for(int i = 0; i < value.length - 1; i++){
            if(value[i] != value[i + 1]){
                if(value[i + 1] == 0){
                    zeroCount += 1;
                } else{
                    oneCount += 1;
                }
            }
        }
        System.out.print(Math.min(zeroCount, oneCount));
    }
}
