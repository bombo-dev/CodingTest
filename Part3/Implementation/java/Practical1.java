import java.io.*;
import java.util.*;
public class Practical1 {
    public static List<String> stringList = new ArrayList<>();
    public static List<Integer> integerList = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        for(int i = 0; i < s.length(); i++){
            if(Character.isAlphabetic(s.charAt(i))){
                stringList.add(Character.toString(s.charAt(i)));
            } else {
                integerList.add(Character.getNumericValue(s.charAt(i)));
            }
        }
        Collections.sort(stringList);

        int sum = 0;
        for(int val : integerList){
            sum += val;
        }

        for(String str: stringList){
            sb.append(str);
        }
        sb.append(sum);
        System.out.print(sb);
    }
}
