package programmers.lv1;

public class question1 {
    public static void main(String[] args){
        String t = "3141592";
        String p = "271";

        int answer = 0;

        if(t.length() == p.length()){
            System.out.print(1);
        }

        for(int i = 0; i < t.length() - p.length() + 1; i++){
            String value = t.substring(i, i + p.length());
            int val = Integer.parseInt(value);
            if(val <= Integer.parseInt(p)){
                answer += 1;
            }
        }
        System.out.print(answer);
    }
}
