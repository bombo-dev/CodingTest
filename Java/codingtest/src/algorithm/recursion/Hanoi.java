package algorithm.recursion;

public class Hanoi {

    public static int count = 0;
    // a + b + c = 6
    // b = 6 - a- c
    // a -> c
    public static void play(int start, int des, int n){
        if(n == 1){
            System.out.println("start [" + start + "] 에서 , des [" + des + "]로 이동");
            return;
        }
        play(start, 6 - start - des, n - 1);
        System.out.println("start [" + start + "] 에서 , des [" + des + "]로 이동");
        play(6 - start - des, des, n - 1);

    }

    public static void main(String[] args){
        play(1, 3, 4);
        System.out.println("총 횟수 : " + (int)(Math.pow(2, 4) - 1));
    }
}
