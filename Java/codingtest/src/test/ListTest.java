package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListTest {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i);
        }
        long end = System.currentTimeMillis();
        System.out.print("arrayList 조회 시간 : ");
        System.out.println(end - start + "ms");

        ListIterator<Integer> integerListIterator = linkedList.listIterator();
        start = System.currentTimeMillis();

        while (integerListIterator.hasNext()) {
            integerListIterator.next();
        }
        end = System.currentTimeMillis();
        System.out.print("linkedList 조회 시간 : "); // 적어도 10분 넘게 걸림
        System.out.println(end - start + "ms");
    }
}
