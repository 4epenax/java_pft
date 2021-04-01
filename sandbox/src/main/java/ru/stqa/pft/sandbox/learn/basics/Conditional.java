package ru.stqa.pft.sandbox.learn.basics;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Conditional {
    public static void main(String[] args) {
        compare(3);
        compare(6);
        compare(5);
    }

    public static void compare(int a) {
        //напишите тут ваш код
        if (a < 5) {
            System.out.println("Число меньше 5");
        } else if (a > 5) {
            System.out.println("Число больше 5");
        } else {
            System.out.println("Число равно 5");
        }
    }
}

class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(reader.readLine());
        if (s>0){
            s=s*2;
        }else if (s<0){
            s++;
        }else {
            s=0;
        }
        System.out.println(s);
    }
}