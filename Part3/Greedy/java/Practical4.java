import java.io.*;
import java.util.*;
public class Practical4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] init = br.readLine().split(" ");
        int[] num = new int[n];
        for(int i = 0; i < n; i++){
            num[i] = Integer.parseInt(init[i]);
        }
        int sum = 0;
        Arrays.sort(num);

        if(num[0] == 1) {
            sum += num[0];
            for (int i = 1; i < num.length; i++) {
                int value = num[i];
                if( sum < value ){
                    break;
                } else{
                    sum += value;
                }
            }
        }
        System.out.print(sum + 1);
    }
}
