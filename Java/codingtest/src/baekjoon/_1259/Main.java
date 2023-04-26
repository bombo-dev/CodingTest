package baekjoon._1259;

import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        play();
        System.out.print(sb);
    }

    private static void play() throws IOException {
        while(true) {
            String s = br.readLine();
            if(s.equals("0"))
                break;

            if(isPalindrome(s)) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }
    }

    static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left <= right) {
            if(s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
