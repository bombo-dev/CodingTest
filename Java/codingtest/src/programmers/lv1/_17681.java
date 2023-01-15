package programmers.lv1;

public class _17681 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int[][] new_arr1 = new int[n][n];
        int[][] new_arr2 = new int[n][n];
        int[][] result = new int[n][n];

        String [] answer = new String[n];

        for(int i = 0; i < arr1.length; i++){
            String value = binaryRadix(arr1[i], n);
            setArr(new_arr1[i], value);
        }

        for(int i = 0; i < arr2.length; i++){
            String value = binaryRadix(arr2[i], n);
            setArr(new_arr2[i], value);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                result[i][j] = new_arr1[i][j] | new_arr2[i][j];
            }
        }

        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                if(result[i][j] == 1)
                    sb.append("#");
                else
                    sb.append(" ");
            }
            answer[i] = sb.toString();
        }
        return answer;
    }

    public void setArr(int[] arr, String value){
        for(int i = 0; i < value.length(); i++){
            arr[i] = Character.getNumericValue(value.charAt(i));
        }
    }

    public String binaryRadix(int value, int length){
        StringBuilder sb = new StringBuilder();
        while(value > 0){
            sb.insert(0, value % 2);
            value /= 2;
        }
        if(length - sb.toString().length() > 0){
            sb.insert(0, "0".repeat(length - sb.toString().length()));
        }

        return sb.toString().substring(sb.toString().length() - length, sb.toString().length());
    }

    public String[] solution2(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }

        for (int i = 0; i < n; i++) {
            result[i] = String.format("%" + n + "s", result[i]);
            result[i] = result[i].replaceAll("1", "#");
            result[i] = result[i].replaceAll("0", " ");
        }

        return result;
    }
}
