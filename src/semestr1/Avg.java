package semestr1;

public class Avg {

// zwrócić wybraną liczbę z ciągu
// ciag fibo
// 1 1 2 3 5 8 13 21 34 itd
    // policz średnią z ciagu fibo


    public static void main(String[] args) {

        int[] ciag = new int[30];
// wypełnij tablicę
        int suma = 0;
        ciag[0] = 1;
        ciag[1] = 1;
        for (int i = 2; i < ciag.length; i++) {
            ciag[i] = ciag[i - 1] + ciag[i - 2];
        }

        for (int i = 0; i < ciag.length; i++) {
            suma += ciag[i];
            System.out.println("Element " + (i + 1) + " = " + ciag[i]);
        }

        System.out.println("");
        System.out.println("Element nr 22= " + ciag[21]);

        System.out.println("");
        System.out.println("suma elementów= " + suma);
        System.out.println("");
        System.out.println("średnia= " + suma / ciag.length);

    }
}
