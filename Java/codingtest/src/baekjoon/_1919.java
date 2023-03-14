package baekjoon;

import java.io.*;
import java.util.*;

public class _1919 {
    static String a, b;
    static int[] aArr, bArr;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine();
        b = br.readLine();

        ans = 0;

        aArr = new int[26];
        bArr = new int[26];

        for (int i = 0; i < a.length(); i++) {
            aArr[a.charAt(i) - 'a']++;
        }

        for (int i = 0; i < b.length(); i++) {
            bArr[b.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(aArr[i] != bArr[i])
                ans += Math.abs(aArr[i] - bArr[i]);
        }

        System.out.println(ans);
    }
}
