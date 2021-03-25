package ru.stqa.pft.sandbox.learn.arrays;

public class Array {

    public static void main(String[] args){

        int[] arrs = null;

        cahnges(arrs);
    }

    public static void cahnges(int[] arr){


        if (arr != null && arr.length != 0){

            int temp = arr[arr.length -1]; // 5
            for (int i = 0; i < arr.length; i++){
                System.out.print(" " + arr[i]);
            }

            System.out.println();
            arr[arr.length -1] = arr[0]; // 9
            for (int i = 0; i < arr.length; i++){
                System.out.print(" " + arr[i]);
            }

            System.out.println();
            arr[0] = temp; // 5
            for (int i = 0; i < arr.length; i++){
                System.out.print(" " + arr[i]);
            }

            System.out.println();
        }
    }
}
