package test;

import java.io.*;
import java.util.*;

public class Question1 {
	
	public int InputInt() {
		int num;
		Scanner sc = new Scanner(System.in);
		try {
			num = Integer.parseInt(sc.nextLine());
		}catch (Exception e) {num = -1;}
		return num;
	}
	
	public boolean IsPrime(int k) {
		for (int i = 2; i < k; i++) {
			
			if(k % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	
	public static void main(String arg[]) {
		int m;
		Question1 Q1 = new Question1();
		System.out.print("Enter m: ");
		m = Q1.InputInt();
		
		while(m < 2 || m > 200){
			System.out.print("=== INVALID INPUT ===");
			System.out.print("Please 5enter Integer 2 < m < 200: ");
			m = Q1.InputInt();
		}
			
		int count=0;
		int run=2;
		
		System.out.println("=== YOUR PRIME NUMBER NEED ===");
		do{
			if (Q1.IsPrime(run))
			{
				System.out.print(run + "\t");
				count++;
			}
			run++;
		}while(count < m);
	}
}
	