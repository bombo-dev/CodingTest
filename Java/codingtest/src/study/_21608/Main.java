package study._21608;

import java.io.*;
import java.util.*;

class Student {
    int number;
    Position position;
    List<Student> likedStudent = new ArrayList<>();

    Student(int number) {
        this.number = number;
    }

    public void addLikeStudent(Student student) {
        likedStudent.add(student);
    }

    public Position findPosition(int N, int[][] map) {
        int[][] likedMap = new int[N][N];
        List<Position> resultList = new ArrayList<>();
        int max = 0;
        for (Student student : likedStudent) {
            if (student.position != null) {
                List<Position> positions = student.position.adjacentPosition(N, map);
                for (Position pos : positions) {
                    likedMap[pos.x][pos.y]++;
                    max = Math.max(likedMap[pos.x][pos.y], max);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (likedMap[i][j] == max && map[i][j] == 0)
                    resultList.add(new Position(i, j));
            }
        }

//        System.out.println(number + "의 max 칸 찾기");
//        resultList.forEach(System.out::print);
//        System.out.println();

        if (resultList.size() == 1)
            return resultList.get(0);

        return findPositionSecond(resultList, map, N);
    }

    private Position findPositionSecond(List<Position> list, int[][] map, int N) {
        int maxEmpty = 0;
        List<Position> resultList = new ArrayList<>();

        for (Position position : list) {
            maxEmpty = Math.max(maxEmpty, position.findEmpty(N, map));
        }

        for (Position position : list) {
            if (position.findEmpty(N, map) == maxEmpty) {
                resultList.add(position);
            }
        }
//        System.out.println(number + "의 인접한 칸이 가장 많은 칸 찾기");
//        resultList.forEach(System.out::print);
//        System.out.println();

        if (resultList.size() == 1)
            return resultList.get(0);

        return findPositionThird(resultList);
    }

    private Position findPositionThird(List<Position> list) {
        Collections.sort(list);
//        System.out.println(number + "의 행렬 중 가장 첫번 째");
//        list.forEach(System.out::print);
//        System.out.println();
        return list.get(0);
    }

    public int calcSatisfaction(int[][] map, int N) {
        List<Integer> numberList = new ArrayList<>();

        for (Student student : likedStudent) {
            numberList.add(student.number);
        }

        int count = position.countSatisfaction(map, numberList, N);

        if (count == 0) {
            return 0;
        } else if (count == 1) {
            return 1;
        } else if (count == 2) {
            return 10;
        } else if (count == 3) {
            return 100;
        }
        return 1000;
    }
}

class Position implements Comparable<Position> {

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int x;
    int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public List<Position> adjacentPosition(int N, int[][] map) {
        List<Position> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue;

            if(map[nx][ny] != 0)
                continue;

            list.add(new Position(nx, ny));
        }
        return list;
    }

    public int findEmpty(int N, int[][] map) {
        int emptyCount = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] != 0)
                continue;

            emptyCount++;
        }

        return emptyCount;
    }

    public int countSatisfaction(int[][] map, List<Integer> number, int N) {
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }

            if (number.contains(map[nx][ny]))
                count++;
        }
        return count;
    }

    @Override
    public int compareTo(Position p) {
        if (this.x == p.x)
            return this.y - p.y;
        return this.x - p.x;
    }
}

public class Main {
    static int N;
    static int[][] map;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Student> studentSequence = new ArrayList<>();
    static Map<Integer, Student> studentInfo = new HashMap<>();


    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        N = stoi(br.readLine());
        map = new int[N][N];
        for (int i = 1; i <= N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int primeStudent = stoi(st.nextToken());
            if (!studentInfo.containsKey(primeStudent)) {
                studentInfo.put(primeStudent, new Student(primeStudent));
            }

            Student inputStudent = studentInfo.get(primeStudent);
            studentSequence.add(inputStudent);

            for (int j = 0; j < 4; j++) {
                int likedStudentNumber = stoi(st.nextToken());
                if (!studentInfo.containsKey(likedStudentNumber)) {
                    studentInfo.put(likedStudentNumber, new Student(likedStudentNumber));
                }
                Student likedStudent = studentInfo.get(likedStudentNumber);
                inputStudent.addLikeStudent(likedStudent);
            }
        }
    }

    static void solve() {
        for (Student student : studentSequence) {
            student.position = student.findPosition(N, map);
            map[student.position.x][student.position.y] = student.number;

//            System.out.println(student.number + "의 위치를 찾고난 이후의 map");
//            for(int i = 0; i < N; i++) {
//                for(int j = 0; j < N; j++) {
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("=========================");
        }

        int sum = 0;

        for (Student student : studentSequence) {
            sum += student.calcSatisfaction(map, N);
        }

        System.out.print(sum);
    }

    static void print() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int stoi(String value) {
        return Integer.parseInt(value);
    }
}

