package programmers.lv2;

import java.util.*;

class MoveNumber {
    long number;
    int movedCount = 0;

    MoveNumber(long number, int movedCount) {
        this.number = number;
        this.movedCount = movedCount;
    }
}
public class _118667 {
    static Queue<MoveNumber> q1 = new LinkedList<>();
    static Queue<MoveNumber> q2 = new LinkedList<>();
    static long sum1 = 0;
    static long sum2 = 0;
    static boolean complete;

    public int solution(int[] queue1, int[] queue2) {
        init(queue1, queue2);
        return logic();
    }

    void init(int[] queue1, int[] queue2) {
        for(int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.offer(new MoveNumber(queue1[i], 0));
            q2.offer(new MoveNumber(queue2[i], 0));
        }
    }

    int logic() {
        int count = 0;
        if(sum1 == sum2)
            return 0;
        while(!q1.isEmpty() && !q2.isEmpty()) {
            if(sum1 > sum2) {
                MoveNumber value = q1.poll();
                long val = value.number;
                int movedCount = value.movedCount;

                if(movedCount > 2)
                    return -1;

                q2.offer(new MoveNumber(val, movedCount + 1));
                sum1 -= val;
                sum2 += val;
                count++;
            } else {
                MoveNumber value = q2.poll();
                long val = value.number;
                int movedCount = value.movedCount;

                if(movedCount > 2)
                    return -1;
                q1.offer(new MoveNumber(val, movedCount + 1));
                sum2 -= val;
                sum1 += val;
                count++;
            }

            if(sum1 == sum2){
                return count;
            }
        }
        return -1;
    }
}
