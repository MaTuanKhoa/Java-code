package FINAL_Test;
import java.io.*;
import java.util.*;
public class Question1 {
	public int inputInt() {
		int m;
		Scanner sc = new Scanner(System.in);
		try {
			m = Integer.parseInt(sc.nextLine());
		}catch(Exception e) {m=-1;}
		return m;
	}
	public boolean isPrime(int k) {
		for(int i=2;i<k;i++)
			if(k%i==0) return false;
		
		return true;
	}
	public static void main(String arg[]) {
		Question1 tmp = new Question1();
		int so;
		do {
			System.out.print("Enter a random integer (2<=m<=100):");
			so = tmp.inputInt();
			if(so<2 || so>100) System.out.println("\t Wrong value => Re-Enter!");
		}while(so<2 || so>100);
		
		System.out.println("\n === LIST OF THE FIRST m-Primes IS ====");
		int count=0;
		int run=2;
		while(count<so) {
			if(tmp.isPrime(run)) {
				System.out.print("\t " + run);
				count++; 
			}
			run++;
		}
	}
}
