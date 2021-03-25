package ru.stqa.pft.sandbox.learn.arrays;

import java.util.Arrays;
import java.util.Scanner;

// сортировка пузырьковым методом
public class SortingBubbles {

    public static void main(String[] args){

        // объявляется сканер для ввода
        Scanner input = new Scanner(System.in);
        System.out.println("Введите длину массива: ");
        // считывается ввод с клавиатуры (размер массива) и записывается в переменную
        int size = input.nextInt();
        // создаётся массив с введённым размером
        int bubbles[] = new int[size];

        System.out.println("Введите значения массива: ");
        // цикл для заполнения массива
        for (int i = 0; i < size; i++){
            // массив заполняется элементами, введёнными с клавиатуры
            bubbles[i] = input.nextInt();
        }

        System.out.print("Получен массив: ");
        // цикл для вывода введённого массива
        for (int i = 0; i < size; i++);
        System.out.println(Arrays.toString(bubbles));

        //int[] bubbles = {8,5,3,9,6,1,7,0,4,2};

        // цикл сортировки массива - работает, пока не завершится сортировка
        for (int j = 1; j < size; j++){
            // цикл для сравнения значений в массиве - работает, пока не пройдёт по всему массиву
            for (int i = 1; i < size; i++){
                // если значение слева больше, чем справа, то выполняется метод swap реализующий сдвиг
                if (bubbles[i-1]>bubbles[i]){
                    swap(bubbles, i-1, i);
                }
            }
        }
        System.out.println("Массив отсортирован: " + Arrays.toString(bubbles));
    }

    // метод реализовывающий сдиг значения в массиве влево на одну позицию
    public static void swap(int[] array, int n1, int n2) {
        // объявляется переменная, которая равняется первой(из двух) полученной из массива
        int temp = array[n1];
        // массив с полученной первой переменной приравнивается ко второй полученной переменной
        array[n1] = array[n2];
        // вторая полученная переменная получает значение из первой переменной
        array[n2] = temp;
    }
}
