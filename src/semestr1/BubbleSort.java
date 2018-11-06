package semestr1;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {9, 3, 8, 4, 6, 77};
        System.out.println("Tablica przed sortowaniem bąbelkowym:");
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println("");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                   int temp;
                   if (a[j]>a[j+1]){
                       temp = a[j+1];
                       a[j+1]=a[j];
                       a[j]=temp;
                   }
            }
        }

        System.out.println("Tablica po sortowaniu:");
        for (int i =0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }



    }


}
