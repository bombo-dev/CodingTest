import java.io.*;
import java.util.*;

class Student implements Comparable<Student> {
    private String name;
    private int score;

    Student(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String getName(){
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    @Override
    public int compareTo(Student student){
        return this.score - student.score;
    }
}
public class Question2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine().trim());
        List<Student> list = new ArrayList<>();
        for(int i = 0; i < count; i++){
            String[] value = br.readLine().split(" ");
            list.add(new Student(value[0], Integer.parseInt(value[1])));
        }
        Collections.sort(list);

        for(Student result : list){
            System.out.print(result.getName() + " ");
        }
    }
}
