package semestr1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IfWordIsPalindrom {
    public static void main(String[] args) throws IOException {

        boolean conti = true;

        while (conti) {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Podaj słowo do sprawdzenia lub wpisz KONIEC aby zakończyć");
            String word = bf.readLine();
            if (word.equals("KONIEC")) {
                conti = false;
            } else {
                word = word.toLowerCase();
                String backWord = "";
                int l = word.length() - 1;
                for (int i = l; i >= 0; i--) {
                    backWord = backWord + word.charAt(i);
                }
                if (word.equals(backWord)) {
                    System.out.println("Słowo " + word + " jest palindromem");
                } else {
                    System.out.println("Słowo " + word + " nie jest palindromem");
                }
            }

        }
        System.exit(0);
    }
}
