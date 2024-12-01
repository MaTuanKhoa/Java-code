package Bai_Thi_test;

import java.util.ArrayList;
import java.util.Scanner;

class Motobike {
    private String code;
    private String manufacturer;
    private int year;
    private String model;

    public Motobike() {}

    public void input() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter code of Motobike: ");
        code = input.nextLine();
        System.out.print("\nEnter manufacturer of Motobike: ");
        manufacturer = input.nextLine();
        boolean key = true;
        do {
            key = true;
            try {
                System.out.print("\nEnter year of Motobike: ");
                year = input.nextInt();
                input.nextLine();
                if (year < 1886 || year > 2024) {
                    System.out.println("Please enter a valid year between 1886 and 2024.");
                    key = false;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid year.");
                key = false;
                input.next();
            }
        } while (!key);

        System.out.print("\nEnter model of Motobike: ");
        model = input.nextLine();
    }

    public void output() {
    	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Motobike information:");
        System.out.println("Code: " + code);
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Year: " + year);
        System.out.println("Model: " + model);
    }

    public boolean isRecent() {
        return year > 2020;
    }
}

public class MotobikeManagement {
    public static void main(String[] args) {
        int m = 0;
        Scanner input = new Scanner(System.in);
        do {
            boolean key1;
            do {
                key1 = true;
                try {
                    System.out.print("Enter m (from 3 to 60): ");
                    m = input.nextInt(); 
                    if (m < 3 || m > 60) {
                        System.out.println("m must be between 3 and 60. Try again.");
                        key1 = false; 
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number between 3 and 60.");
                    key1 = false;
                    input.next();
                }
            } while (!key1);
        } while (m < 3 || m > 60);

        ArrayList<Motobike> List = new ArrayList<>();
        for (int i = 0; i < m; i++) {
        	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Enter info for the " + (i + 1) + " Motobike");
            Motobike mt = new Motobike();
            mt.input(); 
            List.add(mt); 
        }

        outputRecentMotobikes(List);
    }

    public static void outputRecentMotobikes(ArrayList<Motobike> motobikes) {
        System.out.println("Recent Motobikes (manufactured after 2020):");
        for (Motobike mt : motobikes) {
            if (mt.isRecent()) {
                mt.output();
            }
        }
    }
}
