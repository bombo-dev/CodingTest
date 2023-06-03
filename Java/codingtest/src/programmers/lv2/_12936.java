package programmers.lv2;

import java.util.*;
public class _12936 {
    long last = 0;
    long[] fac;
    List<Integer> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public int[] solution(int n, long k) {
        init(n);
        solve(n, k);
        return toInt(n);
    }

    void init(int n) {
        for(int i = 1; i <= n ; i++) {
            list.add(i);
        }

        fac = new long[n + 1];
        fac[0] = 0;
        fac[1] = 1;

        for(int i = 2; i <= n; i++) {
            fac[i] = i * fac[i - 1];
        }
    }

    void solve(int n, long k) {
        if(n == 1) {
            result.add(1);
            return;
        }

        for(int i = 1; i < n;) {
            if(n - i <= 1)
                break;

            long share = 0L;
            if(k % fac[n - i] == 0){
                share = (k / fac[n - i]) - 1;
            } else {
                share = (k / fac[n - i]);
            }

            k -= fac[n - i] * share;
            findAndremove((int)share);
            i++;

            last = k;
        }

        if(last == 1) {
            result.add(list.get(0));
            result.add(list.get(1));
        } else {
            result.add(list.get(1));
            result.add(list.get(0));
        }
    }


    void findAndremove(int share) {
        result.add(list.get(share));
        list.remove(share);
    }

    int[] toInt(int n) {
        int[] answer = new int[n];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
