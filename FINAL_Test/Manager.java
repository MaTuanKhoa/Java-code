package FINAL_Test;

import java.io.*;
import java.util.*;

class Person{
	private String name;
	private int birthYear;
	private String birthPlace;
	Person(){}
	Person(String n, int by, String bp) {
		name = n;
		birthYear = by;
		birthPlace = bp;
	}
	public void inputInfor() { // Method to input information of a current person object
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name:"); name = sc.nextLine().trim();
		
		//  Input birth-year with exception handling
		Question1 tmp = new Question1();
		do {
			System.out.print("Enter birth-Year:"); 
			birthYear = tmp.inputInt();
			if(birthYear<0 || birthYear>2024) 
				System.out.println("\t Wrong value => Re-Enter!");
		}while(birthYear<0 || birthYear>2024);
			
		System.out.print("Enter birth-Place:"); birthPlace = sc.nextLine().trim();
	}
	public void outputInfor() {// Method to output information of a current person object
		System.out.println("\t Name = " + name);
		System.out.println("\t birthYear = " + birthYear);
		System.out.println("\t birthPlace = " + birthPlace);
	}
}
class Student extends Person{
	private double averageScore;
	private String major;
	Student(){}
	Student(String n, int by, String bp, double as, String mj) {
		super(n, by,bp);
		averageScore = as;
		major = mj;
	}
	public double getAverageScore() {return averageScore;}
	public double inputDouble() {
		double d;
		Scanner sc = new Scanner(System.in);
		try {
			d = Integer.parseInt(sc.nextLine());
		}catch(Exception e) {d=-1;}
		return d;
	}
	public void inputInfor() { // Method to input information of a current Student object
		Scanner sc = new Scanner(System.in);
		super.inputInfor();
	
		//  Input averageScore with exception handling
		do {
			System.out.print("Enter averageScore:"); 
			averageScore = inputDouble();
			if(averageScore<0 || averageScore>10) 
				System.out.println("\t Wrong value => Re-Enter!");
		}while(averageScore<0 || averageScore>10);
			
		System.out.print("Enter major:"); major = sc.nextLine().trim();
	}
	public void outputInfor() {
		super.outputInfor();
		System.out.println("\t averageScore = " + averageScore);
		System.out.println("\t major = " + major);
	}
}
public class Manager {
	private int num; // number of students
	private Student list[]; // An array to store information of the list that contains num students
	public void inputList() {
		Question1 tmp = new Question1();
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("Enter number of students (2<=nums<=200):");
			num = tmp.inputInt();
			if(num<2 || num>200) System.out.println("\t Wrong value => Re-Enter!");
		}while(num<2 || num>200);
		
		// Initialize an array that contains m students
		list = new Student[num];
		// input information for the list of m students
		for(int i=0;i<num;i++) {
			list[i] = new Student();
			System.out.println("\n Input information for student <" + i+">");
			list[i].inputInfor();
		}
	}
	public void outputList() {
		for(int i=0;i<num;i++) {
			System.out.println("------------------\n");
			list[i].outputInfor();
		}	
	}
	public void outputHighestScore() {
		double maxAVScore=0;
		for(int i=0;i<num;i++)
			if(list[i].getAverageScore()>maxAVScore)
				maxAVScore = list[i].getAverageScore();
		for(int i=0;i<num;i++)
			if(list[i].getAverageScore()== maxAVScore) {
				list[i].outputInfor();
				System.out.println("\n -----------------------");
			}	
	}
	public static void main(String arg[]) {
		Manager tem = new Manager();
		tem.inputList();
		System.out.println("\n === INFORMATION OF THE Inputted-LIST ====\n");
		tem.outputList();
		System.out.println("\n === LIST OF STUDENTS HAVING HIGHEST-AverageScore ====\n");
		tem.outputHighestScore();
	}
}
