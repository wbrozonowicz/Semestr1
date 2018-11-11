package semestr1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {

    public static void main(String[] args) throws IOException {

        double a;
        double b;
        String line = "";

        System.out.println("Podaj liczbę a =");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        line = bf.readLine();
        a = Double.parseDouble(line);
        System.out.println("Podaj liczbę b =");
        line = bf.readLine();
        b = Double.parseDouble(line);

        System.out.println("Suma =" + (a + b));
        System.out.println("Różnica =" + (a - b));
        System.out.println("Iloczyn =" + (a * b));
        System.out.println("Iloraz =" + (a / b));
        System.out.println("Modulo =" + (a % b));
    }
}
