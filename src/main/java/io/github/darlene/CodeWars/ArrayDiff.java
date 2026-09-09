package io.github.darlene.CodeWars;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;


public class ArrayDiff{
    public static int [] arrayDiff(int [] a, int [] b){
        //Put B in a hashset
        HashSet<Integer> set = new HashSet<>();
        for(int i =  0; i < b.length; i++){
            set.add(b[i]);
        }

        //Fill a to an arrayList
        ArrayList<Integer> list = new ArrayList<>(a.length);
        for (int num : a) {
            if(!set.contains(num)){
                list.add(num);
            }
        }

        int[] lista = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            lista[i] = list.get(i); // Automatically unboxes Integer to int
        }
        return lista;

    }


    //Alternatively but the streaming method has a lot of memory overhead.
    public static int [] arrayDifference(int [] a, int [] b){
        List<Integer> listA = Arrays.stream(a).boxed().collect(Collectors.toList());
        List<Integer> listB = Arrays.stream(b).boxed().collect(Collectors.toList());
        listA.removeAll(listB);
        return listA.stream().mapToInt(e -> e).toArray();
    }
}