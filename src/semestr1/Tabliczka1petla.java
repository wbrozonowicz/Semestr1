package semestr1;

public class Tabliczka1petla {

    public static void main(String[] args) {
        int a = 1; // zwiększamy o 1 co 10 wykonan
        int b = 0; // zwiekszamy o 1 i co 10 wykonan resetujemy

        for (int licznik = 1; licznik <= 100; licznik++) {
            b++;
            System.out.print(a * b + "\t");
            if (b == 10) {
                b = 0;
                a++;
                System.out.println("");
            }
        }
    }
}
