package Bai_Thi_test_3;
import java.util.*;

//a. Person class
class Person {
 private String name;
 private String address;
 private int yearOfBirth;


 public Person() {}

 public Person(String name, String address, int yearOfBirth) {
     this.name = name;
     this.address = address;
     this.yearOfBirth = yearOfBirth;
 }


 public void inputPersonInfo() {
     try (Scanner sc = new  Scanner(System.in)) {
		System.out.print("Enter name:\n");
		 name = sc.nextLine();
		 System.out.print("Enter address:\n");
		 address = sc.nextLine();

		 boolean validInput = false;
		 while (!validInput) {
		     System.out.print("Enter year of birth (must be >= 1924):\n");
		     try {
		         yearOfBirth = sc.nextInt();
		         if (yearOfBirth >= 1924) {
		             validInput = true;  
		         } else {
		             System.out.print("Invalid year. The year of birth must be 1924 or later.\n");
		         }
		     } catch ( InputMismatchException e) {
		         System.out.print("Invalid input. Please enter a valid year (integer).\n");
		         sc.next(); 
		     }
		 }
	}
 }


 public void outputPersonInfo() {
     System.out.print("Name: " + name);
     System.out.print("Address: " + address);
     System.out.print("Year of Birth: " + yearOfBirth);
 }


 public int getYearOfBirth() {
     return yearOfBirth;
 }
}

//b. Customer class that inherits from Person
class Customer extends Person {
 private int yearOfWorking;
 private String position;
 private double salary;

 
 public Customer() {
     super();
 }

 public Customer(String name, String address, int yearOfBirth, int yearOfWorking, String position, double salary) {
     super(name, address, yearOfBirth);
     this.yearOfWorking = yearOfWorking;
     this.position = position;
     this.salary = salary;
 }


 public void inputCustomerInfo() {
     inputPersonInfo();
      try (Scanner sc = new  Scanner(System.in)) {
		boolean validInput = false;
		 while (!validInput) {
		     System.out.print("Enter year of working (must be >= 0):\n");
		     try {
		         yearOfWorking = sc.nextInt();
		         if (yearOfWorking >= 0) {
		             validInput = true;
		         } else {
		             System.out.print("Invalid input. The year of working must be 0 or greater.\n");
		         }
		     } catch ( InputMismatchException e) {
		         System.out.print("Invalid input. Please enter a valid number (integer).\n");
		         sc.next(); 
		     }
		 }

		 sc.nextLine();  
		 System.out.print("Enter position:\n");
		 position = sc.nextLine();

		 
		 validInput = false;
		 while (!validInput) {
		     System.out.print("Enter salary (must be >= 0):\n");
		     try {
		         salary = sc.nextDouble();
		         if (salary >= 0) {
		             validInput = true;  
		         } else {
		             System.out.print("Invalid input. Salary must be 0 or greater.\n");
		         }
		     } catch ( InputMismatchException e) {
		         System.out.print("Invalid input. Please enter a valid number (decimal).\n");
		         sc.next();  
		     }
		 }
	}
 }


 public void outputCustomerInfo() {
     outputPersonInfo();  
     System.out.print("Year of Working: " + yearOfWorking);
     System.out.print("Position: " + position);
     System.out.print("Salary: " + salary);
 }

 public boolean on10Years() {
     return yearOfWorking > 10;
 }
}

//c. CustomerManagement class
public class CustomerManagement {
 private Customer[] customers;

 public void inputCustomers(int m) {
     customers = new Customer[m];
     for (int i = 0; i < m; i++) {
         System.out.print("Input information for customer " + (i + 1) + ":\n");
         customers[i] = new Customer();
         customers[i].inputCustomerInfo();
     }
 }


	public void on10yCustomers() {
     System.out.print("Customers who have been working for more than 10 years:\n");
     for (Customer customer : customers) {
         if (customer.on10Years()) {
             customer.outputCustomerInfo();
             System.out.print("-----------");
         }
     }
 }

 public static void main(String[] args) {
     try (Scanner sc = new  Scanner(System.in)) {
		int m = 0;
		 boolean validInput = false;

		 
		 while (!validInput) {
		     try {
		         System.out.print("Enter the number of customers (10 <= m <= 100):\n");
		         m = sc.nextInt();
		         if (m >= 10 && m <= 100) {
		             validInput = true; 
		         } else {
		             System.out.print("Invalid number of customers. Please enter a number between 10 and 100.\n");
		         }
		     } catch ( InputMismatchException e) {
		         System.out.print("Invalid input. Please enter an integer value.\n");
		         sc.next();
		     }
		 }

		 CustomerManagement cm = new CustomerManagement();
		 cm.inputCustomers(m);
		 cm.on10yCustomers();
	}
 }
}

