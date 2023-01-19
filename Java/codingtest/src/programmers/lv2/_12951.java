package programmers.lv2;

public class _12951 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();

        char[] arr = s.toCharArray();

        if(Character.isLetter(arr[0]))
            arr[0] = Character.toUpperCase(arr[0]);
        for(int i = 1; i < arr.length; i++){
            if(arr[i - 1] == ' ' && Character.isLetter(arr[i]))
                arr[i] = Character.toUpperCase(arr[i]);
        }

        String answer = String.valueOf(arr);
        // String answer = new String(arr);
        // String answer = String.copyValueOf(arr);

        return answer;
    }

    public String solution2(String s) {
        String answer = "";
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;

        for(String ss : sp) {
            answer += flag ? ss.toUpperCase() : ss;
            flag = ss.equals(" ") ? true : false;
        }

        return answer;
    }
}
