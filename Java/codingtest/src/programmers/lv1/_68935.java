package programmers.lv1;

public class _68935 {
    public static void main(String[] args){

        int n = 125;

        int result = solution(n);
        int result2 = solution2(n);

        System.out.println("solution 1 : " + result + ", solution 2 : " + result2);
    }

    public static int solution(int n){
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        // 10 -> 3 진법
        while(n > 0){
            sb.insert(0, n % 3);
            n /= 3;
        }
        String thirdRadix = sb.toString();
        char[] ch = thirdRadix.toCharArray();

        for(int i = 0; i < thirdRadix.length() / 2; i++){
            char temp = ch[i];
            ch[i] = ch[thirdRadix.length() - i - 1];
            ch[thirdRadix.length() - i - 1] = temp;
        }


        for(int i = 0; i < ch.length; i++){
            int value = Character.getNumericValue(ch[i]);
            answer += value * Math.pow(3, ch.length - i - 1);
        }


        return answer;
    }

    public static int solution2(int n){
        String a = "";
        while(n > 0){
            a = a + n % 3;
            n /= 3;
        }
        return Integer.parseInt(a, 3);
    }
}
