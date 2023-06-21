package test;

public class Mod {
    public static void main(String[] args){

        int [] dir = {1, 2, 3, 4};

        int direction = 4;
        int count = 10;
        while(count > 0){
            direction = (direction - 1) % 4;
            count--;
            System.out.println(direction);
            System.out.println(dir[direction]);
        }
    }
}
