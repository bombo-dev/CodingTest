import java.io.*;
import java.util.*;
public class Question1a {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]); //5
        int M = Integer.parseInt(s[1]); //9
        int K = Integer.parseInt(s[2]); //3 2 * 3 6 + 1 7

        List<Integer> list = new ArrayList<>();
        String[] value = br.readLine().split(" ");
        for(String val : value){
            list.add(Integer.parseInt(val));
        }

        Collections.sort(list, Collections.reverseOrder());
        int first = list.get(0);
        int second = list.get(1);

        int count = (M / (K + 1)) * K;
        count += (M % (K + 1));

        int result =  0;
        result += first * count;
        result += second * (M - count);
        System.out.print(result);
    }
}
