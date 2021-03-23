package ru.stqa.pft.sandbox.learn.arrays;

import java.util.Arrays;

// сортировка пузырьковым методом
public class SortingBubbles {

    public static void main(String[] args){

        int[] bubbles = {8,5,3,9,6,1,7,0,4,2};
        int index = bubbles.length;

        for (int j = 1; j < index; j++){
            for (int i = 1; i < index; i++){
                if (bubbles[i]<bubbles[i-1]){
                    swap(bubbles, i, i-1);
                }
            }
        }
        System.out.println(Arrays.toString(bubbles));
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
