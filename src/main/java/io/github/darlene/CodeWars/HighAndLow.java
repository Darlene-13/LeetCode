package io.github.darlene.CodeWars;


public class HighAndLow{

    public static String highAndLow(String numbers){
        // Put the numbers to an arraylist as we convert them to integers
        String [] parts = numbers.split(" ");
        int [] arr = new int[parts.length];
        for(int i  = 0; i < parts.length; i++){
            arr[i] = Integer.parseInt(parts[i]);
        }

        //Record the lowest and highest
        int lowest = arr[0];
        int highest = arr[0];

        //Iterate while the array is not empty
        for (int i  = 0; i < arr.length; i++){
            lowest = Math.min(lowest, arr[i]);
            highest = Math.max(highest, arr[i]);
        }

        String lowHigh = lowest + " " + highest;
        return lowHigh;

    }


    // Alternatively

    public static String getHighAndLow(String numbers){
        String [] array = numbers.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++){
            int value = Integer.parseInt(array[i]);
            if (value < min) min = value;
            if (value > max) max = value;
        }

        return String.format("%d %d", max, min);
    }
}