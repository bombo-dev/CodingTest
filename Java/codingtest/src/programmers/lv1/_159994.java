package programmers.lv1;

public class _159994 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        int index1 = 0;
        int index2 = 0;
        boolean check = false;

        for(int i = 0; i < goal.length; i++){
            check = false;

            if(index1 < cards1.length && goal[i].equals(cards1[index1]) ){
                index1++;
                check = true;
                continue;
            }

            if(index2 < cards2.length && goal[i].equals(cards2[index2])){
                index2++;
                check = true;
                continue;
            }

            if(check == false)
                break;
        }

        if(check == false)
            answer = "No";
        else
            answer = "Yes";

        return answer;
    }
}
