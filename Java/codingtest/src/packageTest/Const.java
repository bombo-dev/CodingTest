package packageTest;

public class Const {

    static public int WIDTH = 200;
    private int k = 0;

    Const(){

    }

    Const(int k){
        this.k = k;
    }

    public void method(){
        System.out.println(k);
    }
}
