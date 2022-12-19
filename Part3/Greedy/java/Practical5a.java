import java.io.*;
public class Practical5a {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] init = br.readLine().split(" ");
        int n = Integer.parseInt(init[0]);
        int weight = Integer.parseInt(init[1]);

        int[] ball = new int[n];
        String[] list = br.readLine().split(" ");

        for(int i = 0; i < list.length; i++){
            ball[i] = Integer.parseInt(list[i]);
        }

        int[] arrWeight = new int[11];
        for(int val : ball){
            arrWeight[val] += 1;
        }

        int result = 0;

        for(int i = 1; i < weight + 1; i++){
            n -= arrWeight[i];
            result += arrWeight[i] * n;
        }
        System.out.print(result);
    }
}
