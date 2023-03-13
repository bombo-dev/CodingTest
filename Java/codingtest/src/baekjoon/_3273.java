package baekjoon;

import java.io.*;
import java.util.*;
public class _3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] value = br.readLine().split(" ");
        int focus = Integer.parseInt(br.readLine());
        int count = 0;

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < value.length; i++){
            list.add(Integer.parseInt(value[i]));
        }

        Collections.sort(list);

        int index = 0;
        while(index <= list.size() - 1){
            if(Collections.binarySearch(list, focus - list.get(index)) >= 0){
                count++;
            }
            index++;
        }

        System.out.println(count / 2);
    }
}
