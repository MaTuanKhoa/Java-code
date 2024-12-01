package test;

import java.io.*;
import java.util.*;

class Person{
	private String name;
	private int birthYear;
	private String birthPlace;
	public Person() {}
	public Person(String name, int birthYear, String birthPlace) {
		super();
		this.name = name;
		this.birthYear = birthYear;
		this.birthPlace = birthPlace;
	}
	
//	public int intInput() {
//		int m;
//		Scanner sc = new Scanner(System.in);
//		try {
//			m = Integer.parseInt(sc.nextLine());
//		}catch(Exception e) {
//			m=-1;
//		}
//		return m;
//	}

	public void inputInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Name of Student: "); 	name = sc.nextLine().trim();
//		System.out.print("Enter Birth Year of Student: "); birthYear = intInput();
		
		Question1 Q1 = new Question1();
		System.out.print("Enter Birth Year of Student(1900-2024): ");	birthYear = Q1.InputInt();
		
		while(birthYear<1900 || birthYear > 2024) { 
			System.out.println("=== INVALID YEAR ==== \n");
			System.out.print("Please Enter 1900-2024 in Birth Year: ");	birthYear = Q1.InputInt();
		}
		
		System.out.print("Enter Birth Place of Student: "); 	birthPlace = sc.nextLine().trim();
	}	
	public void outputInfo() {
		System.out.println("Name of Student: " + name);
		System.out.println("Birth Year of Student: " + birthYear);
		System.out.println("Birth Place of Student: " + birthPlace);
	}
	
}

class Student extends Person{
	private double avgScore;
	private String major;
	public Student() {}
	public Student(String name, int birthYear, String birthPlace, double avgScore, String major) {
		super(name, birthYear, birthPlace);
		this.avgScore = avgScore;
		this.major = major;
	}
	
	public double inputDouble() {
		double d;
		Scanner sc = new Scanner(System.in);
		try {
			d = Double.parseDouble(sc.nextLine());
		}catch (Exception e) {
			d = -1;
		}
		return d;
	}
	
	public void inputInfo() {
		Scanner sc = new Scanner(System.in);
		super.inputInfo();
		
	
		System.out.print("Enter Average Score of Student: ");	avgScore = inputDouble();
		
		while (avgScore<0 || avgScore>10) {
			System.out.println("=== INVALID SCORE ==== \n 0-10 ");
			System.out.print("Please Enter Valid Average Score: ");	avgScore = inputDouble();
		}
	
		System.out.print("Enter Major of Student: "); 	major = sc.nextLine().trim();
	}
	public void outputInfo() {
		super.outputInfo();
		System.out.println("Average Score of Student: " + avgScore);
		System.out.println("Major of Student: " + major);
	}
	public double getAvg() {return avgScore;}
}
	

public class Manager {
	int m;
	private Student list[];
	
	public void inputList() {
		Question1 Q1b = new Question1();
		System.out.print("Enter Number of Student: ");	m = Q1b.InputInt();
		
		while(m < 2 || m > 200) { 
			System.out.println("=== INVALID NUMBER STUDENT ==== \n 2-200");
			System.out.print("Please Enter Valid Number Student: ");	m = Q1b.InputInt();
		}
		list = new Student[m];
		for (int i = 0; i < m; i++) {
			System.out.println("\n===> Enter Student number " + i);
			list[i] = new Student();
			list[i].inputInfo();
			System.out.println("-----------------------------");
		}
	}
	public void outList() {
		double max=0;
		System.out.println("=== INFOMATION OF HIGHEST AVERAGE SCORE ===");
		for (int i = 0; i < m; i++)
			if (max < list[i].getAvg()) {max = list[i].getAvg();}

		for (int i = 0; i < m; i++) {
			if(list[i].getAvg()==max) {
				list[i].outputInfo();
				System.out.println("-----------------------------");
		}
	}
}

	public static void main(String agr[]) {
		Manager mg = new Manager();
		mg.inputList();
		mg.outList();
	}
}
