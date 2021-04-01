package ru.stqa.pft.sandbox.learn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String x = reader.readLine();
        String s = reader.readLine();
        System.out.println("Через " + x + " лет " + s + " захватит мир. Му-ха-ха!");
    }
}
