package semestr1;

import java.util.Random;

public class Tablica1 {

    public static void main(String[] args) {
        int[] tablica = new int[100];


        Random r = new Random();
        for (int i = 0; i < tablica.length; i++) {
            tablica[i] = r.nextInt(100);
        }

        for (int i=0; i<tablica.length;i++)
            System.out.println("Liczba " + (i + 1) + " = " + tablica[i] + "\t");

        int max = tablica[0];
        int maxPos =0;

        for (int i = 1; i < tablica.length; i++)
            if (tablica[i] > max) {
                max = tablica[i];
                maxPos = i;
            }
        System.out.println("Max = " + max + " na pozycji nr "+ (maxPos+1));
    }
}
