import java.io.*;
import java.util.*;

// 이진 탐색 라이브러리 이용
public class Question1a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int[] arr = new int[n];
        String[] s = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr);

        int findCount = Integer.parseInt(br.readLine().trim());
        String[] value = br.readLine().split(" ");

        for(int i = 0; i < value.length; i++){
            int find = Integer.parseInt(value[i]);
            if(Arrays.binarySearch(arr, find) >= 0){
                System.out.print("yes ");
            } else{
                System.out.print("no ");
            }
        }
    }
}
