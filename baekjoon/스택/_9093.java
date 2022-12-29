import java.io.*;
import java.util.*;
public class _9093 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            String [] value = br.readLine().split(" ");
            for(int j = 0; j < value.length; j++){
                String s = value[j];
                for(int k = s.length() - 1; k >= 0; k--){
                    sb.append(Character.toString(s.charAt(k)));
                }
                sb.append(" ");
            }
            System.out.print(sb);
        }

    }
}
