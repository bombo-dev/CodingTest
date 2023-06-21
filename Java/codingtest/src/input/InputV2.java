package input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputV2 {
    public void inputV1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        for(int i = 0; i < n; i++){
            String input2 = br.readLine();
            for(int j = 0; j < m; j++){
                int a = input2.charAt(j) - '0';
                System.out.print(a);
            }
            System.out.println();
        }
    }

    public void inputV2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        for(int i = 0; i < n; i++){
            String[] input2 = br.readLine().split(" ");
            for(int j = 0; j < m; j++){
                int a = Integer.parseInt(input2[j]);
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    public void inputV3() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        for(int i = 0; i < s.length(); i++){
            String numIndex = "0";
            System.out.println("[" + s.charAt(i) + numIndex.repeat(s.length() -1 -i) + "]");
        }
    }

    public void inputStringBuilder(){
        StringBuilder sb = new StringBuilder();

        sb.append("abc");
        sb.deleteCharAt(2);

        System.out.println(sb);
    }

    public void inputRadixConverter(int radix){
        String s = "30";
        int aa = Integer.parseInt(s, radix);
        System.out.println(aa);
    }
}
