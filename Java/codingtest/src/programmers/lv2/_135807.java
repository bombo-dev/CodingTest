package programmers.lv2;

import java.util.Arrays;

public class _135807 {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int result1 = result(arrayA, arrayB);
        int result2 = result(arrayB, arrayA);
        answer = Math.max(result1, result2);
        return answer;
    }

    public int result(int[] array1, int[] array2){
        int[] new_array1 = new int[array1.length];
        int[] new_array2 = new int[array2.length];

        int result = 0;

        for(int i = 0; i < array1.length; i++){
            new_array1[i] = array1[i];
        }

        for(int i = 0; i < array2.length; i++){
            new_array2[i] = array2[i];
        }

        Arrays.sort(new_array1);
        Arrays.sort(new_array2);

        int value = new_array1[0];
        boolean check = false;

        for(int i = 1; i <= (int)Math.sqrt(value); i++){
            if(value % i == 0){
                for(int j = 0; j < new_array1.length; j++){
                    if(new_array1[j] % i != 0){
                        check = true;
                        break;
                    }
                }

                for(int j = 0; j < new_array2.length; j++){
                    if(new_array2[j] % i == 0){
                        check = true;
                        break;
                    }
                }

                if(check != true)
                    result = Math.max(result, i);

                check = false;
                for(int j = 0; j < new_array1.length; j++){
                    if(new_array1[j] % (value / i) != 0){
                        check = true;
                        break;
                    }
                }

                for(int j = 0; j < new_array2.length; j++){
                    if(new_array2[j] % (value / i) == 0){
                        check = true;
                        break;
                    }
                }
                if(check != true)
                    result = Math.max(result, value / i);
                // System.out.println("현재 결과 값 : " + result);
            }
        }
        return result;
    }
}
