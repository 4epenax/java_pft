package ru.stqa.pft.sandbox.old;

public class PoolPuzzleOne {

    public static void main(String[] args){

        int x=0;
    //TODO:
        while (x<1){

            x=x-1;
            if (x<1){
                System.out.print("a");
            }

            x=x+2;

            if (x>1){
                System.out.print(" ");
                x=x-2;
            }

            if (x==1){
                System.out.print("noise");
            }

            if (x<4){
                System.out.print("annoys");
            }
            System.out.println("");
            x=x-2;
        }
    }
}
