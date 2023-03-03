package programmers.lv2;

import java.util.*;
public class _92335 {
    static int count = 0;
    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            int remain = n % k;
            n /= k;
            sb.insert(0, remain);
        }
        String kRadix = sb.toString();
        StringTokenizer st = new StringTokenizer(kRadix, "0");
        while(st.hasMoreTokens()){
            count += primeCheck(Long.parseLong(st.nextToken()));
        }
        return count;
    }

    public int primeCheck(long value){
        if(value == 1)
            return 0;

        for(int i = 2; i <= Math.sqrt(value); i++){
            if(value % i == 0)
                return 0;
        }
        return 1;
    }
}
