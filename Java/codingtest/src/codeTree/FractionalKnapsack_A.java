package codeTree;

import java.io.*;
import java.util.*;

public class FractionalKnapsack_A {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int Weight = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        Jewel[] jewelArr = new Jewel[N];
        for(int i = 0; i < N; i++){
            String[] val = br.readLine().split(" ");
            int weight = Integer.parseInt(val[0]);
            int value = Integer.parseInt(val[1]);
            jewelArr[i] = new Jewel(weight, value);
        }


        Arrays.sort(jewelArr, new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                return (o2.value / o2.weight) - (o1.value / o1.weight);
            }
        });

        int greedyWeight = 0;
        double greedyValue = 0.0;
        for(Jewel jewel : jewelArr){
            if(greedyWeight + jewel.weight < Weight) {
                greedyWeight += jewel.weight;
                greedyValue += jewel.value;
            } else {
                greedyValue += ((double)jewel.value / jewel.weight) * (Weight - greedyWeight);
                greedyWeight += Weight - greedyWeight;
                break;
            }
        }

        for(Jewel jewel : jewelArr){
            System.out.println("무게 : [" + jewel.weight + "], 가치 : [" + jewel.value + "]");
        }


        System.out.println("무게 : " + greedyValue);
        System.out.print("최대 가방에 담을 수 있는 무게  : " + Math.floor(greedyValue * 1000) / 1000.0);
    }
}
