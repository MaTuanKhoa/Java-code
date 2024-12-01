package fibonancy;
import java.util.Scanner;

public class Fibonacci {
    public int n;
    public int[] a;

    public Fibonacci() {
        try (Scanner input = new Scanner(System.in)) {
			System.out.print("Enter an integer (N): ");
			n = input.nextInt();
		}
        a = new int[n];
    }

    public void Fibo() {
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i < n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
    }

    public void display() {
        System.out.println("Fibonacci:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        Fibonacci fibo = new Fibonacci();
        fibo.Fibo();
        fibo.display();
    }
}
