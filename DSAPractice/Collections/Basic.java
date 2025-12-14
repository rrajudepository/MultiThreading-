package DSAPractice.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Basic {
    public static void main(String[] args) {
        List<Integer> value = new ArrayList<>();
        Collections.addAll(value, 1,2,3,4,5,6,7,8,10,11);
        Iterator<Integer> it = value.iterator();

        while(it.hasNext()){
            int val = it.next();
            System.out.print(val+" ");
        }
        System.out.println();
        value.forEach((Integer a)->System.out.print(a+" "));
        System.out.println();

        System.out.println("size of list: "+value.size());
        System.out.println("4th element of list: "+ value.get(4));

        System.out.println("Adding 12 at 4th index: ");
        value.add(4, 12);
        System.out.println(value);

        System.out.println("Setting 6th index element as 13");
        value.set(6,13);
        System.out.println(value);

        System.out.println("Sorting list");
        Collections.sort(value);
        System.out.println(value);

        System.out.println("Reversing the element of list: ");
        Collections.reverse(value);
        System.out.println(value);

        System.out.println("Max element in the list: "+Collections.max(value));
        System.out.println("Min element in the list: "+ Collections.min(value));




        int min = Math.min(16,Math.max(9,15));
        int max = Math.max(16, Math.min(20,14));
        System.out.println("Min value: "+ min+ " Max value: "+ max); //15 and 16

        System.out.println("Largest value: "+Integer.MAX_VALUE);
        System.out.println("Smallest value: "+Integer.MIN_VALUE);

        //Arrays
        int val[]=new int[10];
        //int val[] = {1,2,3,4,5,6,7,8};
        Arrays.fill(val, -1);

        val[3]=5;
        val[4]=4;
        int size = val.length;
        System.out.println("Size of array is "+ size);

        List<List<Integer>> dp = new ArrayList<>();
        /* 
        dp.add(new ArrayList<>(Arrays.asList(1,2,3,4,5)));
        dp.add(new ArrayList<>(Arrays.asList(6,5,4,3,2,1)));
        dp.add(new ArrayList<>(Arrays.asList(7,8,9,10)));
        */
        Collections.addAll(dp, 
        new ArrayList<>(Arrays.asList(1,2,3,4,5)),
        new ArrayList<>(Arrays.asList(6,5,4,3,2,1)),
        new ArrayList<>(Arrays.asList(7,8,9,10)));
      
        System.out.println("2nd row and 3rd column element: "+ dp.get(1).get(2)); //print 4

        



    }
}
