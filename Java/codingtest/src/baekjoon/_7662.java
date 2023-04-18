package baekjoon;

import java.io.*;
import java.util.*;

public class _7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int K = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();

            for (int j = 0; j < K; j++) {
                String[] test = br.readLine().split(" ");
                char command = test[0].charAt(0);
                int value = Integer.parseInt(test[1]);

                if (command == 'I') {
                    treeMap.put(value, treeMap.getOrDefault(value, 0) + 1);
                } else {
                    if (treeMap.isEmpty()) {
                        continue;
                    }

                    if (value == 1) {
                        // Last = 최댓값
                        if(treeMap.get(treeMap.lastKey()) > 1){
                            treeMap.put(treeMap.lastKey(), treeMap.get(treeMap.lastKey()) - 1);
                        } else {
                            treeMap.remove(treeMap.lastKey());
                        }
                    } else {
                        // First = 최솟값
                        if(treeMap.get(treeMap.firstKey()) > 1){
                            treeMap.put(treeMap.firstKey(), treeMap.get(treeMap.firstKey()) - 1);
                        } else {
                            treeMap.remove(treeMap.firstKey());
                        }
                    }
                }
            }
            if(treeMap.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(treeMap.lastKey() + " " + treeMap.firstKey());
            }
        }
    }
}
