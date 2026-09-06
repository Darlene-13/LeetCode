package io.github.darlene.CodeWars;


public class PhoneNumber{
    public String createPhoneNumber(int [] num){

        //Create a phone number template
        String number = new String("(xxx) xxx-xxxx");
        for (int i: num){
            number.replaceFirst("x", Integer.toString(i));
        }

        return number;
    }


}