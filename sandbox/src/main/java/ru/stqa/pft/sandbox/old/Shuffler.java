package ru.stqa.pft.sandbox.old;

public class Shuffler {

    public static void main(String[] args){
        int x = 3;
        while (x > 0){
            if(x > 2){
                System.out.print("a");
            }
            x--;
            System.out.print("-");
            if (x == 2){
                System.out.print("b c");
            }
            if (x == 1){
                System.out.print("d");
                x--;
            }
        }
    }
}