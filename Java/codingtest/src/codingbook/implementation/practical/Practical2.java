package codingbook.implementation.practical;

import java.io.*;

public class Practical2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String value = br.readLine();
        int half = value.length() / 2;

        int sum1 = 0;
        int sum2 = 0;

        for(int i = 0; i < half; i++){
            sum1 += Character.getNumericValue(value.charAt(i));
        }
        for(int i = half; i < value.length(); i++){
            sum2 += Character.getNumericValue(value.charAt(i));
        }

        if(sum1 == sum2){
            System.out.print("LUCKY");
        } else{
            System.out.print("READY");
        }
    }
}
