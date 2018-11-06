
package semestr1;

import java.util.Scanner;

public class MinAdd {
    public static void main(String[] args) {
        int haur;
        Scanner sk = new Scanner(System.in);
        do {
            System.out.println("Podaj czas: godz (0-24)");
            haur = Integer.parseInt(sk.next());}
        while ((haur > 23) || (haur<0));
        int minute;
        do {
            System.out.println("Podaj czas: min (0-59)");
            minute = Integer.parseInt(sk.next());
        }
        while ((minute > 59) || (minute<0));
        System.out.println("Ile minut dodac?");
        int addMinutes;
        addMinutes = Integer.parseInt(sk.next());
        int resultMin;
        resultMin = (minute + addMinutes)%60;
        int resultHaur;
        resultHaur = haur+(minute+addMinutes)/60;
        if (resultHaur>23){
            resultHaur = resultHaur%24;
        }
        String haurPrefix;
        String minPrefix;
        if (resultHaur<10){
            haurPrefix="0";
        } else {
            haurPrefix="";
        }
        if (resultMin<10){
            minPrefix="0";
        } else {
            minPrefix="";
        }
        System.out.println("wynik = "+haurPrefix+resultHaur+":"+minPrefix+resultMin);
        sk.close();
    }
}
