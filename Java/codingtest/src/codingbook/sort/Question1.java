package codingbook.sort;

import java.io.*;
import java.util.*;
public class Question1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine().trim());
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < count; i++){
            int value = Integer.parseInt(br.readLine().trim());
            list.add(value);
        }
        list.sort(Collections.reverseOrder());
        for(int value : list){
            System.out.print(value + " ");
        }
    }
}
