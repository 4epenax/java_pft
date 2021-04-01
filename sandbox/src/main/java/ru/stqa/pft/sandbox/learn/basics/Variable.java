package ru.stqa.pft.sandbox.learn;

public class Variable {

    public int count = 0;     //объявили переменную класса

    public void run() {
        count = 15;           //обращение к переменной класса
        int count = 10;       //объявили локальную переменную метода
        count++;             //обращение к переменной метода
    }
}
