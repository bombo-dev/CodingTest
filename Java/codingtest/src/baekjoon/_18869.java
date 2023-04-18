package baekjoon;

import java.io.*;
import java.util.*;

class Planet implements Comparable<Planet> {

    int index;
    int size;

    Planet(int index, int size) {
        this.index = index;
        this.size = size;
    }

    @Override
    public int compareTo(Planet p) {
        return this.size - p.size;
    }

}

public class _18869 {
    static List<ArrayList<Planet>> list = new ArrayList<>();
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken()); // 우주의 개수
        int N = Integer.parseInt(st.nextToken()); // 행성의 개수


        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            list.add(new ArrayList<>());
            for(int j = 0; j < N; j++) {
                int size = Integer.parseInt(st.nextToken());
                list.get(i).add(new Planet(j, size));
            }
        }

        for(int i = 0; i < M; i++){
            Collections.sort(list.get(i));
        }

        for(int i = 0; i < M - 1; i++){
            for(int j = i + 1; j < M; j++){
                boolean success = true;
                for(int k = 0; k < N; k++){
                    if(list.get(i).get(k).index != list.get(j).get(k).index) {
                        success = false;
                        break;
                    } else {
                        if(k != N - 1 && list.get(i).get(k).size < list.get(i).get(k + 1).size != list.get(j).get(k).size < list.get(j).get(k + 1).size){
                            success = false;
                            break;
                        }
                    }
                }
                if(success)
                    count++;
            }
        }
        System.out.print(count);
    }
}
