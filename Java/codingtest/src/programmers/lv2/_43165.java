package programmers.lv2;

public class _43165 {

    static int pattern = 0;
    static boolean[] visitedMinus;

    public static void main(String[] args) {
        int target = 3;
        int[] numbers = new int[]{1, 1, 1, 1, 1};

        for(int i = 0; i <= numbers.length; i++){
            visitedMinus = new boolean[numbers.length];
            backTracking(numbers, 0, i, target);
        }

        System.out.println(pattern);
    }

    public static void backTracking(int[] numbers, int depth, int minus, int target){

        if(depth == numbers.length && minus == 0){
            int sum = 0;
            for(int i = 0; i < numbers.length; i++){
                if(visitedMinus[i] == true){
                    sum -= numbers[i];
                } else {
                    sum += numbers[i];
                }
            }
            if(sum == target)
                pattern++;

            return;
        }

        if(depth == numbers.length){
            return;
        }

        if(minus != 0) {
            visitedMinus[depth] = true;
            backTracking(numbers, depth + 1, minus - 1, target);

            visitedMinus[depth] = false;
            backTracking(numbers, depth + 1, minus, target);
        } else {
            backTracking(numbers, depth + 1, minus, target);
        }
    }
}
