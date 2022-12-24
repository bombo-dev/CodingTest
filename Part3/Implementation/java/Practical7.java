import java.io.*;
import java.util.*;

class Combination {
    private int n;
    private int r;
    private int[] now;
    private List<ArrayList<Position>> result;

    public List<ArrayList<Position>> getResult() {
        return result;
    }

    public Combination(int n, int r){
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<ArrayList<Position>>();
    }

    public void combination(List<Position> arr, int depth, int index, int target){
        if(depth == r) {
            ArrayList<Position> temp = new ArrayList<>();
            for(int i = 0; i < now.length; i++) {
                temp.add(arr.get(now[i]));
            }
            result.add(temp);
            return;
        }
        if (target == n) return;
        now[index] = target;
        combination(arr, depth + 1, index + 1, target + 1);
        combination(arr, depth, index, target + 1);
    }
}

class Position {
    private int x;
    private int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
public class Practical7 {

    public static List<Position> homes = new ArrayList<>();
    public static List<Position> chickens = new ArrayList<>();

    public static int getSum(List<Position> candidates) {
        int result = 0;
        for (int i = 0; i < homes.size(); i++){
            int hx = homes.get(i).getX();
            int hy = homes.get(i).getY();

            int temp = (int) 1e9;
            for (int j = 0; j < candidates.size(); j++) {
                int cx = candidates.get(j).getX();
                int cy = candidates.get(j).getY();
                temp = Math.min(temp, Math.abs(hx-cx) + Math.abs(hy - cy));
            }
            result += temp;
        }
        return result;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] init = br.readLine().split(" ");
        int n = Integer.parseInt(init[0]);
        int m = Integer.parseInt(init[1]);

        for(int i = 0; i < n; i++){
            String[] value = br.readLine().split(" ");
            for(int j = 0; j < value.length; j++){
                int val = Integer.parseInt(value[j]);
                if(val == 1){
                    homes.add(new Position(i + 1, j + 1));
                } else if(val == 2){
                    chickens.add(new Position(i + 1, j + 1));
                }
            }
        }

        Combination comb = new Combination(chickens.size(), m);
        comb.combination(chickens, 0, 0, 0);
        List<ArrayList<Position>> chickenList = comb.getResult();

        int result = (int)1e9;
        for (int i = 0; i < chickenList.size(); i++) {
            result = Math.min(result, getSum(chickenList.get(i)));
        }
        System.out.println(result);
    }
}
