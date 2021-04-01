package ru.stqa.pft.sandbox.learn.arrays;

public class Array {

    public static void main(String[] args) {

        // обявление массива
        int[] arrs = {2, 4, 8};

        // вызов метода
        cahnges(arrs);
    }

    // метод, реализующий свап первой и последней переменной
    public static void cahnges(int[] arr) {

        // условный оператор, реализующий проверку на корретность ввода (не null и не 0)
        if (arr != null && arr.length != 0) {

            // объявляется буферная переменная (последний элемент в массиве - длина массива одна(-1) позиция)
            int temp = arr[arr.length - 1]; // 2
            // выводится текущий статус массива(без изменений)
            for (int i = 0; i < arr.length; i++) {
                System.out.print(" " + arr[i]); // 2 4 8
            }
            System.out.println(); // перенос строки

            // последнему элементу присваивается значение из первого (последний элемент массива теперь равняется первому)
            arr[arr.length - 1] = arr[0]; // 2
            // выводится текущий статус массива(после изменения последнего элемента)
            for (int i = 0; i < arr.length; i++) {
                System.out.print(" " + arr[i]); // 2 4 2
            }
            System.out.println();

            // первому элементу(индекс 0) присваивается значение из буферной переменной
            arr[0] = temp; // 8
            // выводится текущий статус массива (после изменения первого элемента)
            for (int i = 0; i < arr.length; i++) {
                System.out.print(" " + arr[i]); // 8 4 2
            }
        }
    }
}
