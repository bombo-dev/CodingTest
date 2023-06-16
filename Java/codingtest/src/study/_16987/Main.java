package study._16987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static List<Egg> eggs = new ArrayList<>();
    static int max = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            eggs.add(new Egg(s, w));
        }
        //0 1 2
        backTracking(0);
        System.out.print(max);
    }

    static void backTracking(int mainNumber) {
        if (mainNumber == N) {
            int brokenCount = 0;

            for (Egg egg : eggs) {
                if (egg.isBreak()) {
                    brokenCount++;
                }
            }

            max = Math.max(brokenCount, max);
            return;
        }

        boolean isHit = false;
        for (int i = 0; i < N; i++) {
            if (i != mainNumber && !eggs.get(i).isBreak() && !eggs.get(mainNumber).isBreak()) {
                isHit = true;
                Egg mainEgg = eggs.get(mainNumber);
                Egg subEgg = eggs.get(i);
                mainEgg.butt(subEgg);
                backTracking(mainNumber + 1);
                mainEgg.heal(subEgg);
            }
        }

        if (!isHit) {
            backTracking(mainNumber + 1);
        }
    }

    static class Egg {
        int s;
        int w;

        Egg(int s, int w) {
            this.s = s;
            this.w = w;
        }

        public void butt(Egg e2) {
            this.s -= e2.w;
            e2.s -= this.w;
        }

        public void heal(Egg e2) {
            this.s += e2.w;
            e2.s += this.w;
        }

        public boolean isBreak() {
            return this.s <= 0;
        }

        @Override
        public String toString() {
            return "[s : " + s + " w : " + w + "]";
        }
    }
}
