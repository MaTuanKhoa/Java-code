package sinh_vien;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

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
