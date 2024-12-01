package fibonancy;

import java.util.Scanner;

public class NumberProperty {
	private int n;
	private int[] a;
	private int[] b;
	private int[] c;

    public void prime() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter an integer (N): ");
            n = input.nextInt();
        }
        a = new int[n];
        b = new int[n];
        c = new int[n];
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
    
	public void palindrome() {
		int count = 0;
        for (int num = 1; count < n; num++) {
        	if (isPalindrome(num)) {
        		b[count] = num;
        		count++;
        	}
        }

        System.out.println("Palindromic numbers:");
        for (int i = 0; i < n; i++) {
        	System.out.print(b[i] + " ");
        }
        System.out.println();
	}
    
	
	public boolean isPalindrome(int num) {
            int original = num;
            int reversed = 0;

            while (num > 0) {
                int digit = num % 10;
                reversed = reversed * 10 + digit;
                num /= 10;
            }

            return original == reversed;
        }
	
	public void prime_palindrome() {
		int count = 0;
        for (int num = 1; count < n; num++) {
        	if (isPalindrome(num)&&(isPrime(num))) {
        		b[count] = num;
        		count++;
        	}
        }

        System.out.println("Palindromic prime numbers:");
        for (int i = 0; i < n; i++) {
        	System.out.print(b[i] + " ");
        }
        System.out.println();
	}

	private void armstrongNumbers() {
		
        int count = 0; 
        int sumA = 0;
        for (int num = 1; count < n; num++) {
            if (isArmstrong(num)) {
                c[count] = num;
                count++;
            }
        }

        System.out.println("Các số Armstrong đầu tiên:");
        for (int i = 0; i < n; i++) {
            sumA += c[i];
        }
        System.out.println(sumA/count);
	}

	public boolean isArmstrong(int num) {
	        int original = num;
	        int sum = 0;
	        int numDigits = String.valueOf(num).length();

	        while (num > 0) {
	            int digit = num % 10;
	            sum += Math.pow(digit, numDigits);
	            num /= 10;
	        }

	        return original == sum;
	    }
	
	
	 public static void main(String[] args) {
		 NumberProperty num1 = new NumberProperty();
	        num1.prime();
	        num1.generatePrimes();
	        num1.display();
	        num1.palindrome();
	        num1.prime_palindrome();
	        num1.armstrongNumbers();
	    }


}
