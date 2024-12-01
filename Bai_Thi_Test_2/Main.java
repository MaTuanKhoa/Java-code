package Bai_Thi_Test_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ASUS\\eclipse-workspace\\Bai thi\\src\\Bai_Thi_Test_2\\Staff";
        ArrayList<Staff> staffList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 6) {
                    String name = parts[0].trim();
                    int yearOfBirth = Integer.parseInt(parts[1].trim());
                    String placeOfBirth = parts[2].trim();
                    double salary = Double.parseDouble(parts[3].trim());
                    double bonus = Double.parseDouble(parts[4].trim());
                    int yearsOfWorking = Integer.parseInt(parts[5].trim());

                    Staff staff = new Staff(name, yearOfBirth, placeOfBirth, salary, bonus, yearsOfWorking);
                    staffList.add(staff);
                } else {
                    System.out.println("Invalid line in file: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number: " + e.getMessage());
            return;
        }


        Staff maxIncomeStaff = staffList.stream().max((s1, s2) -> Double.compare(s1.getIncome(), s2.getIncome())).orElse(null);

        if (maxIncomeStaff != null) {
            System.out.println("Staff with largest income:");
            System.out.printf("Name: %s\nSalary: %.2f\nBonus: %.2f\nYears of working: %d\nTotal income: %.2f\n",
                    maxIncomeStaff.getName(), maxIncomeStaff.getSalary(), maxIncomeStaff.getBonus(), maxIncomeStaff.getYearsOfWorking(), maxIncomeStaff.getIncome());
        }
    }
}


class Person {
    private String name;
    private int yearOfBirth;
    private String placeOfBirth;

    public Person(String name, int yearOfBirth, String placeOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.placeOfBirth = placeOfBirth;
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }
}


class Staff extends Person {
    private double salary;
    private double bonus;
    private int yearsOfWorking;

    public Staff(String name, int yearOfBirth, String placeOfBirth, double salary, double bonus, int yearsOfWorking) {
        super(name, yearOfBirth, placeOfBirth);
        this.salary = salary;
        this.bonus = bonus;
        this.yearsOfWorking = yearsOfWorking;
    }

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }

    public int getYearsOfWorking() {
        return yearsOfWorking;
    }

    public double getIncome() {
        return salary + yearsOfWorking * 200000 + bonus;
    }
}
