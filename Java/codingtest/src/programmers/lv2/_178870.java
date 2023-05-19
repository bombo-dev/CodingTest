package programmers.lv2;

import java.util.*;

class Permutation implements Comparable<Permutation> {
    int start;
    int end;

    public Permutation(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getLength() {
        return end - start;
    }

    @Override
    public int compareTo(Permutation p) {
        if(getLength() == p.getLength())
            return start - p.start;

        return getLength() - p.getLength();
    }
}
public class _178870 {
    public int[] solution(int[] sequence, int k) {
        PriorityQueue<Permutation> pq = new PriorityQueue<>();
        int left = 0;
        int right = 0;
        int sum = sequence[0];

        while(left <= right) {

            if(sum == k) {
                pq.offer(new Permutation(left, right));
                if(right != sequence.length - 1){
                    right++;
                    sum += sequence[right];
                } else {
                    sum -= sequence[left];
                    left++;
                }
            } else if(sum < k) {
                if(right == sequence.length - 1)
                    break;
                right++;
                sum += sequence[right];
            } else if(sum > k) {
                sum -= sequence[left];
                left++;
            }
        }

        Permutation result = pq.poll();

        return new int[]{result.start, result.end};
    }
}
