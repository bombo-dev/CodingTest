import java.util.*;
public class dfs {

    public static boolean[] visited = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void dfsImpl(int x){
        visited[x] = true;
        System.out.print(x + " ");

        for(int i = 0; i < graph.get(x).size(); i++){
            int y = graph.get(x).get(i);
            if(!visited[y]){
                dfsImpl(y);
            }
        }
    }

    public static void main(String[] args){
        for(int i = 0; i < 9; i++){
            ArrayList<Integer> list = new ArrayList<>();
            graph.add(list);
          // graph.add(new ArrayList<Integer>());
        }

        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        graph.get(2).add(1);
        graph.get(2).add(7);

        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        graph.get(4).add(3);
        graph.get(4).add(5);

        graph.get(5).add(3);
        graph.get(5).add(4);

        graph.get(6).add(7);

        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        graph.get(8).add(1);
        graph.get(8).add(7);

        dfsImpl(1);
    }
}
