package ru.stqa.pft.sandbox.guessing;

public class GuessGame {

    // переменные экземпляра для объектов Player
    Player p1;
    Player p2;
    Player p3;

    public void startGame(){

        // 3 объекта Player с присвоением к переменным экземпляра
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();

        // объявляются переменные для хранения вариантов ответов
        int guessp1 = 0;
        int guessp2 = 0;
        int guessp3 = 0;

        // объявляются переменные для хранения правильности ответов игроков (false or true)
        boolean p1isRight = false;
        boolean p2isRight = false;
        boolean p3isRight = false;

        // создаётся число для угадывания
        int targetNumber = (int) (Math.random()*10);
        System.out.println("Я загадываю число от 0 до 9...");

        while (true){

            System.out.println("Число, которое нужно угадать, - " + targetNumber);

            // вызывается метод guess() из каждого объекта Player
            p1.guess();
            p2.guess();
            p3.guess();

            // извлекаются варианты каждого игрока (результат работы их методов guess()), получая доступ к их переменным number
            guessp1 = p1.number;
            System.out.println("Первый игрок думает, что это " + guessp1);
            guessp2 = p2.number;
            System.out.println("Первый игрок думает, что это " + guessp2);
            guessp3 = p3.number;
            System.out.println("Первый игрок думает, что это " + guessp3);

            // проверяются варианты каждого из игроков на соответствие загаданному числу
            // если игрок угадал, то присваивается соответствующая переменная значением true (по умолчанию она false)
            if (guessp1 == targetNumber){
                p1isRight = true;
            }
            if (guessp2 == targetNumber){
                p2isRight = true;
            }
            if (guessp3 == targetNumber){
                p3isRight = true;
            }

            // если первый игрок или(оператор ||) второй игрок или третий игрок угадал
            if (p1isRight || p2isRight || p3isRight){
                System.out.println("У нас есть победитель!");
                System.out.println("Первый игрок угадал?" + p1isRight);
                System.out.println("Второй игрок угадал?" + p2isRight);
                System.out.println("Третий игрок угадал?" + p3isRight);
                System.out.println("Конец игры.");
                break; // игра окончена, цикл прерывается

            }
            else {
                // игра продолжается, цикл запускается снова
                System.out.println("игроки должны попробовать еще раз");
            }
        }
    }
}
