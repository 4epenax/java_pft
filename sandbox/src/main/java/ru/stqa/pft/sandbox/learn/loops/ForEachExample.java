package ru.stqa.pft.sandbox.learn.loop;

public class ForEachExample {

    public static void main(String[] args) {
        String[] daysOfWeek =
                { "Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье" };


        for (String dayOfWeek : daysOfWeek) {
            System.out.println(dayOfWeek);
        }
    }
}