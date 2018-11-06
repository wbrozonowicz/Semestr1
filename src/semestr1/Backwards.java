package semestr1;

public class Backwards {
    public static void main(String[] args) {
        String text = "Wojtek pisze programy";

        int l = text.length()-1;

        for (int i=l;i>=0;i--){
            System.out.print(text.charAt(i));
        }


    }
}
