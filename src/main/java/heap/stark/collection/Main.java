package heap.stark.collection;

import org.junit.Test;

import java.util.*;

/**
 * blogcode
 * Created by wangzhilei3 on 2018/1/1.
 */
public class Main {
    /**
     *
     */
    @Test
    public void arrayListTest(){
        ArrayList<Integer> arrayList = new ArrayList(10);
        arrayList.addAll(Arrays.asList(1,2,3));
        Integer[] integers = new Integer[2];
        int i;
        integers[1] = 2;
        System.out.println(integers[i =1]);
        Iterator iterator = arrayList.iterator();
        iterator = arrayList.listIterator();
        iterator = arrayList.listIterator(1);


        arrayList.add(1);
        Object[] objects = arrayList.toArray();
        Object[] objects1 = {1};
        assert (!arrayList.toArray().equals(objects1));
        System.out.println(2<<1);
        assert (2<<1==4);
    }
    @Test
    public void linkedListTest(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        Object[] objects = linkedList.toArray();
        Object[] objects1 = {1};
        assert (!linkedList.toArray().equals(objects1));
        Map map = new HashMap();
    }
    @Test
    public void arrays(){
        int[] ints = new int[]{1,2,3,4};
        Arrays.sort(ints);

    }
}
