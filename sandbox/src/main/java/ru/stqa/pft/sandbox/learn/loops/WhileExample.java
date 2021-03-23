package ru.stqa.pft.sandbox.learn.loops;

public class WhileExample {
    public static void main(String[] args) {
        int countDown = 10;

        while (countDown >= 0) {
            System.out.println("До старта: " + countDown);
            countDown --;
        }

        System.out.println("Поехали !");

        int count = 1;
        while (true) {
            System.out.println("Строка №" + count);
            if (count > 3) {
                break;
            }
            count++; // Без наращивания цикл будет выполняться вечно
        }
    }
}