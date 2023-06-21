package input;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest implements DataStructure {
    @Override
    public void implementation() {
        HashSet<Integer> set = new HashSet<>();
        set.add(3);

        for(int item : set){
            System.out.println(item);
        }

        Iterator iter = set.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
