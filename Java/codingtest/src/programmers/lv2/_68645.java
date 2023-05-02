package programmers.lv2;

public class _68645 {
    static int[][] snail;
    static boolean[][] visited;

    public static void main(String[] args) {
        int [] answer = solution(10);
        for(int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public static int[] solution(int n) {
        snail = new int[n][];
        visited = new boolean[n][];
        for(int i = 0; i < n; i++) {
            snail[i] = new int[i + 1];
            visited[i] = new boolean[i + 1];
        }
        logic(n);
        int[] result = makeArr();
        return result;
    }

    static void logic(int n) {
        int number = 1;

        int row = 0;
        int col = 0;

        int rowStart = 0;
        int colStart = 0;
        int rowLast = n;
        int colLastCount = 0;

        snail[row][col] = number++;


        Loop1 : while(true) {

            if(rowStart >= rowLast)
                break;

            while(++row < rowLast) {
                visited[row][col] = true;
                snail[row][col] = number++;
                System.out.println("현재 [row, col, value] : [" + row + "," + col + ", " + (number - 1) + "]");
            }
            row--;

            while(++col < (snail[row].length - colLastCount)) {
                visited[row][col] = true;
                snail[row][col] = number++;
                System.out.println("현재 [row, col, value] : [" + row + "," + col + ", " + (number - 1) + "]");
            }
            col--;

            while(--row > rowStart && --col > colStart) {
                visited[row][col] = true;
                snail[row][col] = number++;
                System.out.println("현재 [row, col, value] : [" + row + "," + col + ", " + (number - 1) + "]");
            }
            row++;

            rowStart++;
            colStart++;
            rowLast--;
            colLastCount++;
            System.out.println("row, [시작, 끝] : " + "[" + rowStart + ", " + rowLast + "]" + ", col, [시작, 끝] : " + "[" + colStart + ", " + colLastCount + "]");
        }
    }

    static int findLastValue(int n) {
        if(n % 2 == 0)
            return (1 + n) * (n / 2);
        else
            return (1 + n) * (n / 2) + ((n + 1) / 2);
    }

    static int[] makeArr() {
        int length = snail.length;
        int arrLength = findLastValue(length);

        int[] result = new int[arrLength];
        int index = 0;
        for(int i = 0; i < length; i++) {
            for(int value : snail[i]) {
                result[index++] = value;
            }
        }

        return result;
    }
}
