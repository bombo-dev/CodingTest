import java.io.*;
import java.util.*;
public class _10828 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String[] s = br.readLine().split(" ");
            if(s.length == 1){
                if(s[0].equals("top")){
                    if(!list.isEmpty()){
                        System.out.println(list.get(list.size() - 1));
                    } else{
                        System.out.println(-1);
                    }
                } else if(s[0].equals("size")){
                    System.out.println(list.size());
                } else if(s[0].equals("empty")){
                    if(!list.isEmpty()){
                        System.out.println(0);
                    } else {
                        System.out.println(1);
                    }
                } else {
                    if(!list.isEmpty()){
                        System.out.println(list.get(list.size() - 1));
                        list.remove(list.size() - 1);
                    } else{
                        System.out.println(-1);
                    }
                }
            } else {
                list.add(Integer.parseInt(s[1]));
            }
        }
    }
}
