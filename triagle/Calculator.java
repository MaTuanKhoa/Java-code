package triagle;
import java.util.Scanner;

public class Calculator {
    private int a;
    private int b;
    private int c;
    private int p;
    private double s;

    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter side a: ");
            a = scanner.nextInt();
            System.out.print("Enter side b: ");
            b = scanner.nextInt();
            System.out.print("Enter side c: ");
            c = scanner.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid integers.");
            getInput();
        } 
        finally {
        	scanner.close();
        }
    }

    public boolean check() {
        if (a > b + c || b > a + c || c > a + b) {
            System.out.println("a, b, c do not form a valid triangle.");
            return false;
        } else {
            System.out.println("a, b, c form a valid triangle.");
            return true;
        }
    }

    public void calculatePerimeter() {
        p = a + b + c;
        System.out.println("Perimeter of the triangle: " + p);
    }

    public void calculateArea() {
        double pHalf = p / 2.0;
        s = Math.sqrt(pHalf * (pHalf - a) * (pHalf - b) * (pHalf - c));
        System.out.println("Area of the triangle: " + s);
    }

    public static void main(String[] args) {
        Calculator triangle = new Calculator();
        triangle.getInput();
        if (triangle.check()) {
            triangle.calculatePerimeter();
            triangle.calculateArea();
        }
    }
}
