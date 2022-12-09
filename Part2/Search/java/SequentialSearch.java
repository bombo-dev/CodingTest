import java.io.*;
public class SequentialSearch {
    public static Integer sequentialSearch(String[] arr, int n, String target){
        for(int i = 0; i < n; i++){
            if(arr[i].equals(target)){
                return i;
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        String find = input[1];

        String[] arr = {"cherry", "apple", "banana", "jongwoon"};
        System.out.print(sequentialSearch(arr, n, find));
    }
}
