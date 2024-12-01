

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Nguoi {
    protected String hoTen;
    protected int namSinh;

    public Nguoi(String hoTen, int namSinh) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
    }

    public void nhapTT() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập họ và tên: ");
        hoTen = scanner.nextLine();
        System.out.print("Nhập năm sinh: ");
        namSinh = scanner.nextInt();
    }

    public void hienThiTT() {
        System.out.println("Họ và tên: " + hoTen);
        System.out.println("Năm sinh: " + namSinh);
    }
}

class SinhVien extends Nguoi {
    public String lop;
    public double diemTrungBinh;

    public SinhVien(String hoTen, int namSinh, String lop, double diemTrungBinh) {
        super(hoTen, namSinh);
        this.lop = lop;
        this.diemTrungBinh = diemTrungBinh;
    }

    
    public void nhapTT() {
        super.nhapTT();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập lớp: ");
        lop = scanner.nextLine();

        boolean validInput = false;
        while (!validInput) {
            System.out.print("Nhập điểm trung bình: ");
            if (scanner.hasNextDouble()) {
                diemTrungBinh = scanner.nextDouble();
                validInput = true;
            } else {
                System.out.println("Vui lòng nhập một số thực làm điểm trung bình: ");
                scanner.nextLine();
            }
        }
    }


    public void hienThiTT() {
        super.hienThiTT();
        System.out.println("Lớp: " + lop);
        System.out.println("Điểm trung bình: " + diemTrungBinh);
    }
}
public class QL_SinhVien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng sinh viên: ");
        int m = scanner.nextInt();
        scanner.nextLine();

        ArrayList<SinhVien> danhSachSinhVien = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            System.out.println("Nhập thông tin sinh viên thứ " + (i + 1));
            SinhVien sv = new SinhVien("", 0, "", 0.0);
            sv.nhapTT();
            danhSachSinhVien.add(sv);
        }

        try {
            PrintWriter writer = new PrintWriter("danhsachsinhvien.txt");
            for (SinhVien sv : danhSachSinhVien) {
                writer.println(sv.hoTen);
                writer.println(sv.namSinh);
                writer.println(sv.lop);
                writer.println(sv.diemTrungBinh);
                writer.println();
            }
            writer.close();
            System.out.println("Đã lưu thông tin sinh viên vào file danhsachsinhvien.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
