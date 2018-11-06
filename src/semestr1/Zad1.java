package semestr1;

public class Zad1 {

    public static void main(String[] args) {

        int x =10;
        int y =20;
        int z =0;

        System.out.println("Początkowe wartości");
        System.out.println("x ="+x);
        System.out.println("y ="+y);

        System.out.println("Zmieniamy wartość");


        z = x;
        x = y;
        y = z;

        System.out.println("x ="+x);
        System.out.println("y ="+y);
    }

}
