package semestr1;

public class BubbleSort {
    public static void main(String[] args) {
        int[] inArray = {9, 3, 8, 4, 6, 77}; // array for bubble sort
        sortMyArray(inArray);
    }

    static void sortMyArray(int[] array) {
        System.out.println("Tablica przed sortowaniem:");
        for (int a : array) {
            System.out.print(a + "\t");
        }
        System.out.println("");
        System.out.println("Tablica po sortowaniu:");
        int temp = 0;
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length - 1; j++) {

                if (array[j] > array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        for (int a : array) {
            System.out.print(a + "\t");
        }
    }


}
