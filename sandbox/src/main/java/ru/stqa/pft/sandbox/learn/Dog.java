package ru.stqa.pft.sandbox.learn;

class Dog {

    String name;

    public static void main(String[] args){

        // создаём объект Dog и получаем к нему доступ
        Dog dog1 = new Dog();
        dog1.bark();
        dog1.name = "Барт";

        // создаём массив типа Dog
        Dog[] myDogs = new Dog[3];

        // в массив помещается несколько элемнтов
        myDogs[0] = new Dog();
        myDogs[1] = new Dog();
        myDogs[2] = dog1;

        // доступ к объектам Dog с помощью ссылок из массива
        myDogs[0].name = "Фред";
        myDogs[1].name = "Джордж";

        // какое имя у myDogs[2]?
        System.out.print("имя последней собаки - ");
        System.out.println(myDogs[2].name);

        // перебераются все элементы массива и вызываются для каждого метод bark()
        int x = 0;
        // массивы содержат переменную length, которая представляет количество хранимых элементов
        while (x < myDogs.length){
            myDogs[x].bark();
            x++;
        }
    }

    public void bark(){
        System.out.println(name + " сказал Гав!");
    }

    public void eat(){}
    public void chaseCat(){}
}
