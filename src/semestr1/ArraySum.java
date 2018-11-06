package semestr1;

public class ArraySum {
    public static void main(String[] args) {
        int[] numbers = new int[40];
        int sum = 0;
        for (int i = 0; i < 40; i++) {
            numbers[i] = i;
            sum = sum + numbers[i];
        }
        for (int a : numbers) {
            System.out.println(a);
        }
        System.out.println(sum);
    }
}
