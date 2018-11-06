package semestr1;

public class Abc {
    public static void main(String []args){

        int znalezionaKombinacja = 0;

        for (int a=1;a<=100;a++)

            for (int b =1;b<=100;b++)

                for (int c=1;c<=100;c++){

                    if ((a*a+b*b)==(c*c)) {

                        System.out.println("Wynik nr "+(++znalezionaKombinacja) + ": \t a="+a+",\t b="+b+",\t c="+c);

                    }

                }

    }
}
