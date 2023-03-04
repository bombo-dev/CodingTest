package programmers.lv2;

public class _17687 {
    public String solution(int n, int t, int m, int p) {
        String[] value = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

        StringBuilder sb = new StringBuilder();
        String radix = createRadix(value, n, t * m);
        int index = p - 1;
        while(t-- > 0){
            sb.append(radix.charAt(index));
            index += m;
        }
        String answer = sb.toString();
        return answer;
    }

    public String createRadix(String[] value, int n, int total){
        StringBuilder sb1 = new StringBuilder();
        sb1.append("0");


        for(int i = 0; i <= total; i++){
            int find = i;
            StringBuilder sb2 = new StringBuilder();
            while(find > 0){
                int remain = find % n;
                find /= n;
                sb2.insert(0, value[remain]);
            }
            sb1.append(sb2.toString());
        }

        return sb1.toString();
    }
}
