import java.io.*;
import java.util.*;

public class Question1c {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        String[] s = br.readLine().split(" ");
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < s.length; i++){
            set.add(Integer.parseInt(s[i]));
        }
        int findCount = Integer.parseInt(br.readLine().trim());
        String[] value = br.readLine().split(" ");

        for(int i = 0; i < value.length; i++){
            if(set.contains(Integer.parseInt(value[i])))
                System.out.print("yes ");
            else{
                System.out.print("no ");
            }
        }
    }
}
