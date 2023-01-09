package programmers.lv1;

import java.util.*;
public class _42840 {
    public List<Integer> solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] score = new int[3];

        for(int i = 0; i < answers.length; i++){
            if(answers[i] == one[i % 5])
                score[0] += 1;
            if(answers[i] == two[i % 8])
                score[1] += 1;
            if(answers[i] == three[i % 10])
                score[2] += 1;
        }
        int index = 0;

        if(score[0] > score[1]){
            index = 1;
            if(score[2] > score[0]){
                index = 3;
            }
        } else {
            index = 2;
            if(score[2] > score[1]){
                index = 3;
            }
        }

        if(score[index - 1] == score[0])
            answer.add(1);
        if(score[index - 1] == score[1])
            answer.add(2);
        if(score[index - 1] == score[2])
            answer.add(3);

        return answer;
    }

    // 회고해야 될 부분, 3중 비교 Math.max 사용
    // List -> toIntArray -> list.stream().mapToInt(i -> i.intValue()).toArray();
    public int[] solution2(int[] answer) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        for(int i=0; i<answer.length; i++) {
            if(answer[i] == a[i%a.length]) {score[0]++;}
            if(answer[i] == b[i%b.length]) {score[1]++;}
            if(answer[i] == c[i%c.length]) {score[2]++;}
        }
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(maxScore == score[0]) {list.add(1);}
        if(maxScore == score[1]) {list.add(2);}
        if(maxScore == score[2]) {list.add(3);}
        return list.stream().mapToInt(i->i.intValue()).toArray();
    }
}
