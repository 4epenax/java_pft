package ru.stqa.pft.sandbox.learn.loop;

public class DoWhileExample {
    public static void main(String[] args) {
        int count = 1;
        do {
            System.out.println("count = " + count);
            count ++;
        } while (count < 11);
    }
}
