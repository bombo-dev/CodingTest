package baekjoon;

import java.io.*;
public class _1780 {
    static int size;
    static int zeroCount;
    static int oneCount;
    static int minusCount;
    static int[][] paper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        paper = new int[size][size];

        for(int i = 0; i < size; i++) {
            String[] value = br.readLine().split(" ");
            for(int j = 0; j < value.length; j++) {
                paper[i][j] = Integer.parseInt(value[j]);
            }
        }

        recursion(0, 0, size);
        System.out.println(minusCount);
        System.out.println(zeroCount);
        System.out.print(oneCount);
    }

    public static void recursion(int x, int y, int nano) {

        int startValue = paper[x][y];
        boolean isNot = false;

        Loop1: for(int i = x; i < x + nano; i++) {
            for(int j = y; j < y + nano; j++) {
                if(startValue != paper[i][j]) {
                    nano /= 3;
                    isNot = true;
                    recursion(x, y, nano);
                    recursion(x, y + nano,  nano);
                    recursion(x, y + nano * 2, nano);
                    recursion(x + nano, y, nano);
                    recursion(x + nano, y + nano,  nano);
                    recursion(x + nano, y + nano * 2, nano);
                    recursion(x + nano * 2, y, nano);
                    recursion(x + nano * 2, y + nano, nano);
                    recursion(x + nano * 2, y + nano * 2, nano);
                    break Loop1;
                }
            }
        }

        if(!isNot) {
            if(startValue == 0) {
                zeroCount++;
            } else if(startValue == 1) {
                oneCount++;
            } else {
                minusCount++;
            }
        }
    }
}
