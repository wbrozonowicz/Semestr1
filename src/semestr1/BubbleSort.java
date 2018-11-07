package semestr1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BubbleSort {
    public static void main(String[] args) {
        int intToAdd;
        String line = "";
        ArrayList<Integer> tab = new ArrayList<>();
        System.out.println("Instrukcja:");
        System.out.println("Podaj kolejne liczby całkowite tablicy do sortowania, zatwierdzaj ENTER'em.");
        System.out.println("Wpisz SORT aby zakończyc wpisywanie tablicy i dokonać sortowania metodą Bubble Sort.");
        System.out.println("Wpisz pierwszą liczbę:");
        do {
            if (tab.size() > 0) {
                System.out.print("Twoja tablica obecnie: [ ");
                for (Object a : tab) {
                    System.out.print(a+" ");
                }
                System.out.println("]");
                System.out.println(" Podaj kolejną liczbę lub wpisz SORT:");
            }
            try {
                BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
                line = bf.readLine();
                if (!line.equals("SORT")) {
                    intToAdd = Integer.parseInt(line);
                    tab.add(intToAdd);
                }
            } catch (Exception e) {
                System.out.println("Podałeś nieprawidłową wartość. Błąd: " + e.getMessage());
                System.out.println("Wpisz prawidłową liczbę lub wpisz SORT:");
            }
        }
        while (!line.equals("SORT"));

        tab.trimToSize();
        sortMyArray(tab);
    }

   private static void sortMyArray(ArrayList<Integer> array) {
        if (array.size() > 0) {
            System.out.println("Tablica przed sortowaniem: ");
            System.out.print("[ ");
            for (Object a : array) {
                System.out.print(a + " ");
            }
            System.out.println("]");
            System.out.println("Tablica po sortowaniu: ");
            System.out.print("[ ");

            for (int i = 0; i < array.size(); i++)
                for (int j = 0; j < array.size() - 1; j++) {
                    int a;
                    int b;
                    a = array.get(j);
                    b = array.get(j + 1);
                    if (a > b) {
                        array.set(j, b);
                        array.set(j + 1, a);
                    }
                }
            for (Object a : array) {
                System.out.print(a + " ");
            }
            System.out.println("]");
        } else {
            System.out.println("Nie było nic do posortowania.");
        }

    }
}
