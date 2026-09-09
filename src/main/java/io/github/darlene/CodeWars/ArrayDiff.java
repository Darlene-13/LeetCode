package io.github.darlene.CodeWars;


import java.util.ArrayList;
import java.util.HashSet;


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
}