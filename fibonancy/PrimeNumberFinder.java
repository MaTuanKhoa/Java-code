package fibonancy;

import java.util.Scanner;

public class PrimeNumberFinder {
	private int n;
	private int[] a;

    public void prime() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter an integer (N): ");
            n = input.nextInt();
        }
        a = new int[n];
    }

    public boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void generatePrimes() {
        int count = 0;
        int num = 2;
        while (count < n) {
            if (isPrime(num)) {
                a[count] = num;
                count++;
            }
            num++;
        }
    }

    public void display() {
        System.out.println("First " + n + " prime numbers:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PrimeNumberFinder num = new PrimeNumberFinder();
        num.prime();
        num.generatePrimes();
        num.display();
    }
}
