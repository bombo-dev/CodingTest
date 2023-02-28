package programmers.lv2;

public class _87390 {
    public static void main(String[] args){
        int n = (int)1e7;

        int left = (int)1e5 + 10000;
        int right = (int)1e5 + 90000;

        int sub = (int)(right - left);

        int[] result = new int[sub + 1];

        int startIndex = 0;

        for(long i = left; i <= right; i++){
            int share = (int)(i / n);
            int remainder = (int)(i % n);

            if(remainder <= share)
                result[startIndex++] = share + 1;
            else
                result[startIndex++] = remainder + 1;
        }

        for(int i = 0; i < sub + 1; i++){
            System.out.print(result[i] + " ");
        }
    }
}
