package ru.stqa.pft.sandbox.guessing;

public class Player {

    int number = 0; // варианта числа

    public void guess(){

        number = (int) (Math.random()*10);
        System.out.println("Думаю, это число " + number);
    }
}