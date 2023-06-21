package codingbook.sort;

import java.util.*;

class Fruit implements Comparable<Fruit> {
    private String name;
    private int price;

    Fruit(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public int getPrice(){
        return this.price;
    }

    @Override
    public int compareTo(Fruit fruit){
        return this.price - fruit.price;
    }
}
public class ObjectSort {
    public static void main(String[] args){
        List<Fruit> list = new ArrayList<>();

        list.add(new Fruit("바나나", 2));
        list.add(new Fruit("사과", 1));
        list.add(new Fruit("파인애플", 3));

        Collections.sort(list);
        for(Fruit val : list){
            System.out.print("(" + val.getName() + "," + val.getPrice() + ") ");
        }
    }
}
