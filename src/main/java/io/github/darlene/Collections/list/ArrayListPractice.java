package io.github.darlene.Collections.list;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListPractice {

    public static void main(String[] args){
        //Create an array list of integers
        ArrayList<Integer> list = new ArrayList<>();

        //Adding elements
        //add(E element)
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        //add(int index, E element)
        list.add(1, 99);
        list.add(2, 98);
        list.add(3, 97);
        list.add(4, 96);
        list.add(5, 95);

        //addAll(Collection)
        ArrayList<Integer> other = new ArrayList<>();
        other.add(40);
        other.add(50);
        list.addAll(other);
        System.out.println(list);
        //Output: 99, 98, 97, 96, 95, 40, 50
        //We did not write 1,2,3,4,5 because once we did list.add(1, 99) etc the initial values were overwritten because it is the same list.

        //addAll(int index, Collection)
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(5);

        ArrayList <Integer> middle = new ArrayList<>();

        middle.add(3);
        middle.add(4);

        numbers.addAll(2, middle);

        System.out.println(numbers);
        //Output = 1,2,3,4,5

        //ACCESSING / CHECKING
        System.out.println(numbers.get(2));
        //Output = 3

        //Getting the size of the elements
        System.out.println(numbers.size());
        //Output = 5

        //Checking whether it is empty
        System.out.println(numbers.isEmpty());
        //Output false ...of course it is supposed to return a boolean.

        //contains(object)
        System.out.println(numbers.contains(3));
        System.out.println(numbers.contains(99));
        //Output: true and false .true we have the number 3 in numbers  list but false because we do not have 99


        //indexOf
        numbers.add(3);
        System.out.println(numbers);
        //Output = 1,2,3,4,5,3
        System.out.println(numbers.indexOf(3));
        //Output = 2

        //lastIndexOf
        System.out.println(numbers.lastIndexOf(3));
        //Output = 5

        //MODIFYING
        //set(index, element)
        numbers.set(1, 99);
        System.out.println(numbers);
        //Output = 1,2,99,4,5,3

        //Removing
        //remove (index)
        numbers.remove(5);
        System.out.println(numbers);
        //Output: 1,2,99,4,5


        //remove(object)
        numbers.remove(Integer.valueOf(99));
        System.out.println(numbers);
        //Output: 1,2,4,5

        //If it were strings
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Darlene");
        strings.add("Wendy");
        strings.add("Nasimiyu");

        System.out.println(strings);
        //Output: Darlene, Wendy, Nasimiyu

        strings.remove("Darlene");
        System.out.println(strings);
        //Output: Wendy, Nasimiyu

        //Clear ...removes everything
        strings.clear();
        numbers.clear();
        System.out.println(strings);
        System.out.println(numbers);
        //Output: []


        //removeAll(Collection)
        ArrayList<Integer> numbers1 = new ArrayList<>(
                Arrays.asList(1,2,3,2,4,2)
        );

        ArrayList<Integer> remove = new ArrayList<>(
                Arrays.asList(2,4)
        );

        numbers1.removeAll(remove);
        System.out.println(numbers1);
        //Output: 1,2

        //removeIf(Predicate)
        //This is used when you want to remove elements that satisfy a certain condition
        numbers.removeIf(num ->num%2 == 0);
        //Remove everything that satisfies this condition, and whatever remains is what I want

        //KEEPING ELEMENTS
        //retainAll(Collection)
        ArrayList<Integer> numbers2 = new ArrayList<>(
                Arrays.asList(1,2,3,4,5)
        );
        ArrayList<Integer> keep = new ArrayList<>(
                Arrays.asList(
                        2,4
                )
        );

        numbers2.retainAll(keep);
        System.out.println(numbers2);
        //Output: 2,4


        //TRAVERSING AN ARRAY
        ArrayList<Integer> numbers3 = new ArrayList<>(
                Arrays.asList(1,2,3,4,5)
        );
        for (Integer num: numbers3){
            System.out.println(num);
        }

        //using ForEach to traverse
        numbers3.forEach(num -> System.out.println(num));

        //CONVERTING TO AN ARRAY
        ArrayList<Integer> numbers4 = new ArrayList<>(
                Arrays.asList(1,2,3,4,5)
        );

        Object[] array = numbers4.toArray();
        Integer[] array2 = numbers4.toArray(new Integer[0]);


        //SUBLIST
        ArrayList<Integer> numbers5 = new ArrayList<>(
                Arrays.asList(10,20,30,40,50)
        );

        List<Integer> part = numbers5.subList(1,4);
        System.out.println(part);
        //Output: 20,30,40
        //The boundaries are to(inclusive) from(exclusive)


    }

}
