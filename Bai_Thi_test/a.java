package Bai_Thi_test;
package DeSo_01;
import java.io.*;
import java.util.*;
class Motobike{
	// Declare attributes
	private String code;
	private String manufacturer;
	private int year;
	private String model;
	// Declare constructors
	Motobike(){}
	Motobike(String c){code = c;}
	Motobike(String code, String manufacturer, int year, String model) {
		this.code = code;
		this.manufacturer = manufacturer;
		this.year = year;
		this.model = model;
	}
	// Declare methods
	public int inputInt() { // Enter an integer value with exception handling
		int d=0;
		Scanner sc = new Scanner(System.in);
		try {
			d= Integer.parseInt(sc.nextLine());
		}catch(Exception e) {
			d=0;
		}
		return d;
	}
	public void inputInfor() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter code :"); code = sc.nextLine();
		System.out.print("Enter manufacturer :"); manufacturer = sc.nextLine();
		
		do {
			System.out.print("Enter year (>0):"); 
			year = inputInt();
			if(year<=0) System.out.print("\t Error! => Please Re-Enter year (>=2024):"); 
		}while(year<=0);
		
		System.out.print("Enter model :"); model = sc.nextLine();
	}
	public void outputInfor() {
		System.out.println("\t\t Code = " + code);
		System.out.println("\t\t Manufacturer = " + manufacturer);
		System.out.println("\t\t Year = " + year);
		System.out.println("\t\t Model = " + model);
	}
	public int getYear() {return year;}
}
	public class MotobikeManagement {
	// Declare attributes
	private int m;
	private Motobike lst[];
	// Declare methods
	public void inputList_Motobike_FromFile() {
		String inFile="D:\\Eclipse_Workspace\\BTJava\\input_MotorbikeList.txt";
		FileReader fr=null;
	    BufferedReader br=null;
	    try {
	        fr = new FileReader(inFile);
	        br = new BufferedReader(fr);
	        String st = "";
	        st = br.readLine(); 
	        
	        //Doc so phan tu cua danh sach khach hang
	        m=Integer.parseInt(st);
	       
	        lst=new Motobike[m];
	        // Doc gia tri cac phan tu cua Mang A
	        for(int i=0;i<m;i++) {
		        st = br.readLine();
		        String gta[] = st.split("\t");
		        		        	        
		        String cod 	= gta[0];
		        String manu 	= gta[1];
		        int	   yea 	= Integer.parseInt(gta[2]);
		        String mod 	= gta[3];
		        
		        lst[i] = new Motobike(cod,manu,yea,mod);
		        
	        }
	        br.close();
	    } catch (IOException er) {er.getMessage();}
	}
	public void inputList_Motobike() {
		Motobike tmp = new Motobike();
		// Input total number of motobikes
		System.out.print("Enter number of motobikes (3<=m<=60):");
		do {
			m = tmp.inputInt();
			if(m<3||m>60) System.out.print("\t Invalid! Enter number of motobikes (3<=m<=60):");
		}while(m<3||m>60);
		// Initialize for the array containing m motobikes
		lst = new Motobike[m];
		// Input information for list of m motobikes
		for(int i=0;i<m;i++) {
			System.out.println("\n----- Input information for motobike <"+(i+1)+">-----");
			lst[i] = new Motobike();
			lst[i].inputInfor();
		}
	}
	public void outputList_Motobike() {
		for(int i=0;i<m;i++) {
			System.out.println("\n-----------------------------------------------");
			lst[i].outputInfor();
		}	
	}
	public void searching() {
		for(int i=0;i<m;i++) 
			if(lst[i].getYear()>2020) {
			System.out.println("\n-----------------------------------------------");
			lst[i].outputInfor();
		}
	}
	public static void main(String arg[]) {
		MotobikeManagement ql = new MotobikeManagement();
		//ql.inputList_Motobike();
		ql.inputList_Motobike_FromFile();
		System.out.println("\n ====== INFORMATION OF THE Motobike's LIST THAT YOU HAVE ENTERED ====== ");
		ql.outputList_Motobike();
		System.out.println("\n ====== INFORMATION OF THE Motobikes THAT HAVE YEARS AFTER 2020 ====== ");
		ql.searching();
	}
	
}
