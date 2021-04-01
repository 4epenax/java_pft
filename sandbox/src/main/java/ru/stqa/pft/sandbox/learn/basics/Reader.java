package ru.stqa.pft.sandbox.learn.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(reader.readLine());

        if (s > 0) {
            s = s * 2;
        } else if (s < 0) {
            s++;
        } else {
            s = 0;
        }

        System.out.println(s);
    }
}