package programmers.lv1;

public class _133499 {
    public static int solution(String[] babbling) {
        int answer = 0;
        boolean check = false;
        String[] al = {"aya", "ye", "woo", "ma"};
        for (int i = 0; i < babbling.length; i++) {
            check = false;
            for (int j = 0; j < al.length; j++) {
                babbling[i].replaceAll(al[j], Character.toString(j));
                if (babbling[i].contains(Character.toString(j) + Character.toString(j))) {
                    check = true;
                    break;
                }
            }
            if (check == true) {
                break;
            } else {
                if (!babbling[i].matches("/[a-z]/g"))
                    break;
                else {
                    answer += 1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] data = {"aya", "yee", "u"};
        System.out.println(solution(data));
    }
}
