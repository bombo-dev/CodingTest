package programmers.lv1;

import java.util.*;

// 1. 회고 같을 경우 정렬법
// 2. 람다 정렬
public class _12915 {
    public String[] solution(String[] strings, int n) {

        Arrays.sort(strings);
        Arrays.sort(strings, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return (int)o1.charAt(n) - (int)o2.charAt(n);
            }
        });

        return strings;
    }

    public static String[] solution2(String[] strings, int n){
        Arrays.sort(strings, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                if(s1.charAt(n) > s2.charAt(n)) return 1;
                else if(s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
                else if(s1.charAt(n) < s2.charAt(n)) return -1;
                else return 0;
            }
        });
        return strings;
    }
}
