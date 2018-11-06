package semestr1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class RandomGame {
    public static void main(String[] args) throws IOException {

        Random r = new Random();
        int wylos = r.nextInt(100);
        boolean graDalej=true;
        System.out.println("Odgadnij wylosowaną liczbę:");
        int liczbaProb =0;

    while (graDalej){
    System.out.println("podaj liczbę: ");
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    liczbaProb++;
    String wczytanyNapis = bf.readLine();
    int podanaLiczba = Integer.parseInt(wczytanyNapis);
        System.out.println("Próba nr"+liczbaProb);
    if (wylos==podanaLiczba){
        System.out.println("Brawo wygrałeś, potrzebowałeś prób "+ liczbaProb);
        graDalej=false;
    } else if (podanaLiczba>wylos){
        System.out.println("Liczba za duża");
    } else {
        System.out.println("Liczba za mała");
    }
}
    }
}
