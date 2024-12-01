package Bai_Thi_Test_2;

import java.util.Scanner;

class Fundamental {
    private int[] a;

    public Fundamental() {}

    public static void main(String[] args) {
        Fundamental num = new Fundamental();
        int m = 0;
        Scanner input = new Scanner(System.in);

        do {
            try {
                System.out.print("Enter number of array: ");
                m = input.nextInt();
            } catch (Exception e) {
                System.out.println("=== Invalid input. Please enter an integer ===");
                input.next();
                m = 0;
            }
        } while (m <= 2 || m >= 10);

        num.a = new int[m];

        System.out.println("Enter " + m + " numbers:");
        for (int i = 0; i < m; i++) {
            num.a[i] = input.nextInt();
        }

        System.out.println("Array elements are:");
        for (int i = 0; i < m; i++) {
            System.out.print(num.a[i] + " ");
        }

        int max = num.a[0];
        for (int i = 1; i < m; i++) {
            if (num.a[i] > max) {
                max = num.a[i];
            }
        }
        input.close();,

        System.out.println("\nThe maximum value in the array is: " + max);
    }
}
