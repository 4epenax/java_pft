package ru.stqa.pft.sandbox;

public class DooBee {

    public static void main(String[] args){
        int x = 0;
        while (x < 2){
            System.out.print("Doo");
            System.out.print("Bee");
            x++;
        }
        if (x == 2){
            System.out.print("Do");
        }
    }
}