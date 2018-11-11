package semestr1;

public class tableMagni2 {

    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        System.out.println("Tabliczka mnożenia na jednej pętli:");
        for (int i = 0; i < 100; i++) {
            a = (i % 10) + 1;
            if (i % 10 == 0) {
                b++;
                System.out.println("");
            }
            System.out.print(b * a + "\t");
        }
    }
}

