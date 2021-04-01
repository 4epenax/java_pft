package ru.stqa.pft.sandbox.learn.basics;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Week {

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
