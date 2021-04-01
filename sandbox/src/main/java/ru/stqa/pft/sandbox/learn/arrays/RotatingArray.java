package ru.stqa.pft.sandbox.learn.arrays;

import java.util.Arrays;

// вращение массива
public class RotatingArray {

    public static void main(String[] args) {

        int[][] arr = {{1, 2}, {4, 3}};

        // переменная, определяющая количество вращений
        int x = 3;

        // выводится текущий статус массива
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println();

        // цикл, реализующий вращение массива
        for (int i = 0; i <= x; i++) {

            // условный оператор, реализующий проверку на корретность ввода (не null и не 0)
            if (arr != null && arr.length != 0) {

                // объявляются буферные переменные
                int temp1 = arr[0][0];
                int temp2 = arr[0][1];
                int temp3 = arr[1][0];
                int temp4 = arr[1][1];

                arr[0][1] = temp1;
                arr[1][1] = temp2;
                arr[1][0] = temp4;
                arr[0][0] = temp3;

                // выводится текущий статус массива
                for (int[] a : arr) {
                    System.out.println(Arrays.toString(a));
                }
                System.out.println();
            }
        }
    }
}
