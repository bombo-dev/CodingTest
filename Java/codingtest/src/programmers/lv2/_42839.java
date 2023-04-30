package programmers.lv2;

public class _42839 {
    static boolean[] isPrimeArr = new boolean[9999999];
    static boolean[] visited;
    static boolean[] findVisited = new boolean[9999999];
    static StringBuilder sb = new StringBuilder();
    static int count = 0;

    public int solution(String numbers) {
        initPrime();
        visited = new boolean[numbers.length()];
        char[] numberArr = numbers.toCharArray();
        findPrime(numberArr, 0);
        return count;
    }

    void initPrime() {
        for(int i = 2; i < (int)Math.sqrt(9999999); i++) {
            if(isPrimeArr[i])
                continue;
            for(int j = i * 2; j < 9999999; j += i) {
                isPrimeArr[j] = true;
            }
        }
        isPrimeArr[0] = true;
        isPrimeArr[1] = true;
    }

    void findPrime(char[] numbers, int depth) {

        int find = 1;

        if(sb.length() != 0) {
            int value = Integer.parseInt(sb.toString());
            find = value;
        }

        if(!findVisited[find] && !isPrimeArr[find]) {
            count++;
        }
        findVisited[find] = true;

        if(depth == numbers.length)
            return;

        for(int i = 0; i < numbers.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sb.append(numbers[i]);
                findPrime(numbers, depth + 1);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }
}
