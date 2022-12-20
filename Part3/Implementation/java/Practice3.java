import java.io.*;

public class Practical3 {

    public static String[] answer = new String[]{
            "aabbaccc",
            "ababcdcdababcdcd",
            "abcabcdede",
            "abcabcabcabcdededededede",
            "xababcdcdababcdcd"
    };

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < answer.length; i++) {
            System.out.println((i + 1) + "번째 테스트 : ");
            solution(answer[i]);
        }
    }

    public static int solution(String s) {
        int answer = s.length();

        for (int step = 1; step < s.length() / 2 + 1; step++) {
            String compressed = "";
            String prev = s.substring(0, step);
            int count = 1;

            for (int i = step; i < s.length(); i = i + step) {
                String str = "";
                for (int j = i; j < i + step; j++) {
                    if (j < s.length())
                        str += s.charAt(j);
                }
                if (prev.equals(str)) {
                    count += 1;
                }
                else {
                    compressed += (count >= 2) ? count + prev : prev;
                    str = "";
                    for (int j = i; j < i + step; j++) {
                        if (j < s.length())
                            str += s.charAt(j);
                    }
                    prev = str;
                    count = 1;
                }
            }
            compressed += (count >= 2)? count + prev : prev;
            answer = Math.min(answer, compressed.length());
            System.out.println("해당 문자열의 " + step + "번 째 나타난 문자열 : " + compressed + "와 그 개수 : " + compressed.length());
        }
        return answer;
    }
}
