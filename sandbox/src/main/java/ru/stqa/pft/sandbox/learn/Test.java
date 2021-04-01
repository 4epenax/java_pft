package ru.stqa.pft.sandbox.learn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.addPrice(50);
        Apple apple2 = new Apple();
        apple2.addPrice(100);
        System.out.println("Стоимость яблок " + Apple.applesPrice);
    }

    public static class Apple {
        public static int applesPrice = 0;

        public static void addPrice(int applesPrice) {
            //напишите тут ваш код
            Apple.applesPrice = Apple.applesPrice + applesPrice;
        }
    }
}


class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(reader.readLine());

        if (s==1){
            System.out.println("понедельник");
        }else if (s==2){
            System.out.println("вторник");
        }else if (s==3){
            System.out.println("среда");
        }else if (s==4){
            System.out.println("четверг");
        }else if (s==5){
            System.out.println("пятница");
        }else if (s==6){
            System.out.println("суббота");
        }else if (s==7){
            System.out.println("воскресенье");
        }else {
            System.out.println("такого дня недели не существует");
        }
    }
}