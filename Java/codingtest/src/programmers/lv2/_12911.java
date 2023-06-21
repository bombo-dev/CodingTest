package programmers.lv2;

public class _12911 {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        String binary = Integer.toBinaryString(n);
        int lastZeroIndex = -1;
        for(int i = 0; i < binary.length() - 1; i++){
            if(binary.charAt(i) == '0' && binary.charAt(i + 1) == '1')
                lastZeroIndex = i;
        }

        if(lastZeroIndex != -1){
            char[] binary_arr = binary.toCharArray();
            binary_arr[lastZeroIndex] = '1';
            binary_arr[lastZeroIndex + 1] = '0';

            int oneCount = 0;
            if(lastZeroIndex + 2 <= binary_arr.length - 1){
                for(int i = lastZeroIndex + 2; i < binary_arr.length; i++){
                    if(binary_arr[i] == '1')
                        oneCount++;
                    binary_arr[i] = '0';
                }
            }

            for(int i = binary_arr.length - 1; i > binary_arr.length - 1 - oneCount; i--){
                binary_arr[i] = '1';
            }
            sb.append(String.valueOf(binary_arr));
            answer = Integer.parseInt(sb.toString(), 2);
        } else {
            sb.append(binary);
            if(binary.charAt(binary.length() - 1) != '0'){
                sb.insert(0, "1");
                sb.deleteCharAt(1);
                sb.insert(1, "0");
                answer = Integer.parseInt(sb.toString(), 2);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2 = sb2.append(sb.toString().substring(1)).reverse();
                sb2.insert(0, "1");
                sb2.insert(1, "0");
                answer = Integer.parseInt(sb2.toString(), 2);
            }
        }
        return answer;
    }

    public int solution2(int n){
        int answer = 0;

        int binaryCount = Integer.bitCount(n);
        int compareNumber = n + 1;

        while(true){
            if(Integer.bitCount(compareNumber) == binaryCount)
                break;

            compareNumber++;
        }

        answer = compareNumber;

        return answer;
    }
}
