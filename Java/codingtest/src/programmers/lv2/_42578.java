package programmers.lv2;
import java.util.*;

// 시간초과 풀이
public class _42578 {

    static int count = 0;
    static Set<String> clothesSet;
    public static void main(String[] args) {
        ArrayList <String[][]> clothesList = new ArrayList<>();
        clothesList.add(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}});
        clothesList.add(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}});

        clothesSet = new HashSet<>();
        for(String[][] clothes : clothesList){
            count = 0;
            for(int i = 1; i <= clothes.length; i++){
                combination(clothes, 0, i, i);
                clothesSet.clear();
            }
            System.out.println(count);
        }


    }

    public static void combination(String[][] arr, int start, int r, int choice){
        if(r == 0) {
            count++;
            print(choice);
            return;
        }

        else {
            for(int i = start; i < arr.length; i++){
                if(clothesSet.add(arr[i][1])) {
                    combination(arr, i + 1, r - 1, choice);
                    clothesSet.remove(arr[i][1]);
                } else {
                    continue;
                }
            }
        }
    }

    public static void print(int i){
        Iterator<String> iter = clothesSet.iterator();
        System.out.println("===== " + i + "개 뽑기" + "=====");
        while(iter.hasNext()){
            System.out.print(iter.next() + " ");
        }
        System.out.println();
    }
}
