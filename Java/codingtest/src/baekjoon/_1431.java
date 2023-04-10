package baekjoon;

import java.io.*;
import java.util.*;
public class _1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) {
                    int o1Count = 0;
                    int o2Count = 0;
                    for(int i = 0; i < o1.length(); i++){
                        if(Character.isDigit(o1.charAt(i))) {
                            o1Count += Character.getNumericValue(o1.charAt(i));
                        }
                        if(Character.isDigit(o2.charAt(i))) {
                            o2Count += Character.getNumericValue(o2.charAt(i));
                        }
                    }
                    if(o1Count == o2Count) {
                        return o1.compareTo(o2);
                    } else {
                        return o1Count - o2Count;
                    }
                }
                return o1.length() - o2.length();
            }
        });

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            sb.append(arr[i]).append("\n");
        }
        System.out.print(sb);
    }
}
