package ru.stqa.pft.sandbox.learn;

public class MovieTestDrive {

    public static void main(String[] args){

        // создание объекта класса(экземпляра) Movie
        Movie one = new Movie();
        // с помощью оператора доступа . присваиваются значения
        one.title = "Как прогореть на акциях";
        one.genre = "Трагедия";
        // с помощью оператора доступа . вызывается метод
        one.rating = -2;

        // создание еще одного объекта класса Movie
        Movie two = new Movie();
        two.title = "Потерянные в офисе";
        two.genre = "Комедия";
        two.rating = 5;

        // и еще раз создание объекта класса Movie
        Movie three = new Movie();
        three.title = "Байт-клуб";
        three.genre = "Трагедия, но в целом весёлая";
        three.rating = 127;
    }
}
