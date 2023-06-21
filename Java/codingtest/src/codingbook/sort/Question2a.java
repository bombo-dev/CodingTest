package codingbook.sort;

import java.util.*;
import java.io.*;
import java.util.Map.Entry;

public class Question2a {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine().trim());

        Map<String, Integer> student = new HashMap<>();
        for(int i = 0; i < count; i++){
            String[] value = br.readLine().split(" ");
            student.put(value[0], Integer.parseInt(value[1]));
        }

        List<Entry<String, Integer>> entry = new ArrayList<>(student.entrySet());
        Collections.sort(entry, new Comparator<Entry<String, Integer>>(){
            @Override
            public int compare(Entry<String, Integer> obj1, Entry<String,Integer> obj2){
                return obj1.getValue().compareTo(obj2.getValue());
            }
        });

        for(Entry<String, Integer> value : entry){
            System.out.print(value.getKey() +" ");
        }
    }
}
