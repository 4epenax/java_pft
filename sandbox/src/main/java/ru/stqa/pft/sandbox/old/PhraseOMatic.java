package ru.stqa.pft.sandbox.old;

public class PhraseOMatic {

    public static void main(String[] args){

        String[] worldListOne = {"круглосуточный","трёх-звенный","30000-футовый","взаимный",
                "обоюдный выигрыш","фронтэнд","на основе веб-технологий",
                "проникающий","умный","шесть сигм","метод критического пути","динамичный"};

        String[] worldListTwo = {"уполномоченный","трудный","чистый продукт","ориентированный",
                "центральный","распределённый","кластеризованный","фирменный","нестандартный ум",
                "позиционированный","сетевой","сфокусированный","использованный с выгодой",
                "выровненный","нацеленный на","общий","совместный","ускоренный"};

        String[] worldListThree = {"процесс","пункт разгрузки","выход из положения",
                "тип структуры","талант","подход","уровень завоёванного внимания",
                "портал","период времени","обзор","образец","пункт следования"};

        int oneLenght = worldListOne.length;
        int twoLenght = worldListTwo.length;
        int threeLenght = worldListThree.length;

        int rand1 = (int) (Math.random()*oneLenght);
        int rand2 = (int) (Math.random()*twoLenght);
        int rand3 = (int) (Math.random()*threeLenght);

        String phrase = worldListOne[rand1] + " " + worldListTwo[rand2] + " " + worldListThree[rand3];

        System.out.println("Всё, что нам нужно, - это " + phrase);
    }
}
